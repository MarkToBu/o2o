package com.imooc.o2o.dao.split;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

/**
 * @author Maktub
 * @Date 2020/5/23 12:28
 */
@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class
                , ResultHandler.class})})
public class DynamicDataSourceInterceptor implements Interceptor {

    private static final String REGEX = ".*insert\\u0020.*|.delete\\u0020.*|.*update\\u0020.*";

    /**
     * 拦截器的具体设置
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        boolean syncActive = TransactionSynchronizationManager.isActualTransactionActive();
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        String lookupKey = DynamicDataSourceHolder.DB_MASTER;

        //非事务操作
        if (!syncActive) {
            //读方法
            if (SqlCommandType.SELECT.equals(statement.getSqlCommandType())) {
                //查询主键的方法
                if (statement.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                    lookupKey = DynamicDataSourceHolder.DB_MASTER;
                } else {
                    BoundSql sqlBound = statement.getBoundSql(args[1]);
                    String sql = sqlBound.getSql().toLowerCase(Locale.CHINA).replace("[\\t\\n\\r]", "");
                    if (sql.matches(REGEX)) {
                        lookupKey = DynamicDataSourceHolder.DB_MASTER;
                    } else {
                        lookupKey = DynamicDataSourceHolder.DB_SLAVE;
                    }
                }

            } else {
                lookupKey = DynamicDataSourceHolder.DB_MASTER;
            }
        }

        log.debug("设置方法[{}] use [{}] Strategy,sqlCommanType[{}]..", statement.getId(), lookupKey);
        DynamicDataSourceHolder.setDbType(lookupKey);
        return invocation.proceed();
    }

    /**
     * 决定拦截的对象 的包装
     *
     * @param o
     * @return
     */
    @Override
    public Object plugin(Object o) {
        if (o instanceof Executor) {
            return Plugin.wrap(o, this);
        } else {
            return o;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
