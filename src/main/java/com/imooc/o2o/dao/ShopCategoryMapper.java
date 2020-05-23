package com.imooc.o2o.dao;

import com.imooc.o2o.pojo.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryMapper {
    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    ShopCategory selectByPrimaryKey(Integer shopCategoryId);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);

    List<ShopCategory> selectShopCategoryByParentId(@Param("parentCategoryId") Integer parentCategoryId);


    List<ShopCategory> queryShopCategory(@Param("shopCategory") ShopCategory category);
}