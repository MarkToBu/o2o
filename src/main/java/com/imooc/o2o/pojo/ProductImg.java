package com.imooc.o2o.pojo;

import java.util.Date;

public class ProductImg {
    private Integer productImgId;

    private String imgAddr;

    private String imgDesc;

    private Integer priority;

    private Date createTime;

    private Integer productId;

    public ProductImg(Integer productImgId, String imgAddr, String imgDesc, Integer priority, Date createTime, Integer productId) {
        this.productImgId = productImgId;
        this.imgAddr = imgAddr;
        this.imgDesc = imgDesc;
        this.priority = priority;
        this.createTime = createTime;
        this.productId = productId;
    }

    public ProductImg() {
        super();
    }

    public Integer getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(Integer productImgId) {
        this.productImgId = productImgId;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr == null ? null : imgAddr.trim();
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc == null ? null : imgDesc.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}