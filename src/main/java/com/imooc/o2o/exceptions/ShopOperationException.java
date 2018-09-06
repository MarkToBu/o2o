package com.imooc.o2o.exceptions;

/**
 * 店铺操作异常
 * */
public class ShopOperationException extends RuntimeException {
    public ShopOperationException(String msg){
        super(msg);
    }
}
