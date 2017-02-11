package com.example.brand.ilovezappos;

/**
 * Created by brand on 2/8/2017.
 */

public class ProductsResponse {

    private Products products;

    public ProductsResponse(Products products){
        this.products = products;
    }

    public Products getProducts(){
        return products;
    }

    public void setProducts(Products products){
        this.products = products;
    }
}
