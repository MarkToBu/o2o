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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

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
