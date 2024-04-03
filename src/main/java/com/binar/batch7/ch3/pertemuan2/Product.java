package com.binar.batch7.ch3.pertemuan2;

import lombok.Data;

import java.util.Optional;

@Data
public class Product {
    private String name;
    private Optional<DetailProduct> detailProduct;

    public Product(String name, Optional<DetailProduct> detailProduct) {
        this.name = name;
        this.detailProduct = detailProduct;
    }
}
