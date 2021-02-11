package com.ruoyi.rabbit.product.entity;

import java.io.Serializable;

public class OrderInfo implements Serializable {
    private Long id;
    private Integer productCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}
