package com.imooc.o2o.service.impl;

import com.imooc.o2o.common.ShopStateEnum;
import com.imooc.o2o.dao.ShopMapper;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.pojo.Shop;
import com.imooc.o2o.service.IShopService;
import com.imooc.o2o.util.FileUtil;
import com.imooc.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;

@Service("iShopService")
public class ShopServiceImpl implements IShopService {

    @Autowired
    ShopMapper shopMapper;
    /** 添加店铺 */
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            shop.setEnableStatus(0);

            int row = shopMapper.insertSelective(shop);
            if(row <= 0){
                throw new ShopOperationException("店铺创建失败");
            }
            if(shopImgInputStream != null){
                try{
                    addShopImg(shop, shopImgInputStream,fileName);
                }catch (Exception e){
                    throw new ShopOperationException("addShopImg.error:" +e.getMessage());
                }
                //更新店铺图片地址
                row = shopMapper.updateByPrimaryKeySelective(shop);
                if(row <= 0){
                    throw new ShopOperationException("更新图片地址失败");
                }
            }

        }catch (Exception e){
            throw new ShopOperationException("addShop error:" +e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);

    }

    private void addShopImg(Shop shop, InputStream shopImgInputSteam,String fileName) {
        //获取shop图片目录的相对值路径
        String  dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputSteam,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
