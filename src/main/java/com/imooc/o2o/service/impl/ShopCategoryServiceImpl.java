package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ShopCategoryMapper;
import com.imooc.o2o.pojo.ShopCategory;
import com.imooc.o2o.service.IShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements IShopCategoryService {
    @Autowired
    ShopCategoryMapper shopCategoryMapper;
    @Override
    public List<ShopCategory> selectShopCategoryByParentId(Integer parentCategoryId) {
        List<ShopCategory> shopCategories = shopCategoryMapper.selectShopCategoryByParentId(parentCategoryId);
        return shopCategories;
    }
}
