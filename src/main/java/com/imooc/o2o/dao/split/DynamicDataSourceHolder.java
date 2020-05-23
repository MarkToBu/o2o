package com.imooc.o2o.dao.split;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * @author Maktub
 * @Date 2020/5/23 10:12
 */
@Slf4j
public class DynamicDataSourceHolder {

    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static final String DB_MASTER = "master";

    public static final String DB_SLAVE = "slave";

    /**
     * @return
     */
    public static String getDbType(){
        String db = contextHolder.get();
        if (db==null) {
            db =DB_MASTER;
        }
        return db;
    }

    /**
     * 设置线程的DBtype
     */
    public static void setDbType(String str){
        log.debug("所使用的的数据源为：" + str);
        contextHolder.set(str);
    }

    /**
     * 清理连接类型
     */
    public static void clearDbType(){
        contextHolder.remove();
    }

}
