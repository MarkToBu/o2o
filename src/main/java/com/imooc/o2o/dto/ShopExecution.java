package com.imooc.o2o.dto;

import com.imooc.o2o.common.ShopStateEnum;
import com.imooc.o2o.pojo.Shop;

import java.util.List;

public class ShopExecution {
    private int status;
    private String stateInfo;
    private int count;
    private Shop shop;
    private List<Shop> shopList;
    public ShopExecution(){

    }
    /** 操作失败时失败时构造 */
    public ShopExecution(ShopStateEnum stateEnum){
        this.status = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    /** 店铺操作成功时返回*/
    public ShopExecution(ShopStateEnum stateEnum,Shop shop) {
        this.status = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList) {
        this.status = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }
}
