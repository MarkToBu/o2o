package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.pojo.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

public interface IShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgshopImgInputStream,String fileName);

    /** 根据id获取shop */
    Shop getByShopId(Integer shopId);

    /** 联合查询 shop */
    Shop getByShopIdAssociation(Integer shopId);

    /** 修改文章图片*/
    ShopExecution modifyShop(Shop shop,InputStream shopImgInputStream,String  fileName) throws ShopOperationException;



}
