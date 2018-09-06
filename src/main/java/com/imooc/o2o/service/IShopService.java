package com.imooc.o2o.service;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.pojo.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public interface IShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
