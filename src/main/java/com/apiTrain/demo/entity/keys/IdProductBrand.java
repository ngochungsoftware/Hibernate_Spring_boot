package com.apiTrain.demo.entity.keys;

import jakarta.persistence.Column;

import java.io.Serializable;

public class IdProductBrand implements Serializable {

    @Column(name = "product_id")
    private long product_id;


    @Column(name = "brand_id")
    private long brand_id;

    public IdProductBrand() {
    }

    public IdProductBrand(long product_id, long brand_id) {
        this.product_id = product_id;
        this.brand_id = brand_id;
    }
}
