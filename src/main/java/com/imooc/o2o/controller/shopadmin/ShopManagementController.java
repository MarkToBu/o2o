package com.imooc.o2o.controller.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.common.ShopStateEnum;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.pojo.PersonInfo;
import com.imooc.o2o.pojo.Shop;
import com.imooc.o2o.service.IShopService;
import com.imooc.o2o.util.FileUtil;
import com.imooc.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    IShopService shopService;

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    private Map<String,Object> registerShop(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = null;
        if(shopStr == null){
            modelMap.put("success",false);
            return modelMap;
        }
        try {
            shop = objectMapper.readValue(shopStr,Shop.class);
        }catch (Exception exception){
            modelMap.put("success",false);
            modelMap.put("errMsg", exception.getMessage());
            return modelMap;
        }
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        //注册店铺
        if(shop != null && shopImg != null){
            PersonInfo owner = new PersonInfo();
            owner.setUserId(8);
            shop.setOwnerId(owner.getUserId());
            File shopImgFile = new File(FileUtil.getImgBasePath() + FileUtil.getRandomFileName());
            try {
                shopImgFile.createNewFile();
            }catch (IOException ex){
                modelMap.put("success",false);
                modelMap.put("errMsg", ex.getMessage());
                return modelMap;
            }
            try {
                inputStreamToFile(shopImg.getInputStream(),shopImgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ShopExecution se = shopService.addShop(shop,shopImg);
            if(se.getStatus() == ShopStateEnum.CHECK.getState()){
                    modelMap.put("success",true);
                    return modelMap;
            }
            modelMap.put("success",false);
            modelMap.put("errMsg",se.getStateInfo());
            return modelMap;

        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺信息");
            return modelMap;
        }

    }
    /** 将流转换成文件 */
    private void inputStreamToFile(InputStream ins, File shopImgFile) {
        try(FileOutputStream os = new FileOutputStream(shopImgFile);BufferedInputStream bufferedInputStream = new BufferedInputStream(ins)){

            byte[] buffer = new byte[1024];
            int data = 0;
            while( (data = bufferedInputStream.read(buffer)) != -1){
               os.write(buffer,0,data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
