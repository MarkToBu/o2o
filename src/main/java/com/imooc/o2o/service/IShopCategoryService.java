package com.imooc.o2o.service;

import com.imooc.o2o.pojo.ShopCategory;

import java.util.List;

public interface IShopCategoryService {
    List<ShopCategory> selectShopCategoryByParentId( Integer parentCategoryId);


}
