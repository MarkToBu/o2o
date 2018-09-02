package com.imooc.o2o.dao;

import com.imooc.o2o.pojo.ProductCategory;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer productCategoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer productCategoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}