package com.binar.batch7.ch3.pertemuan2;

import lombok.Data;

import java.util.Optional;

@Data
public class Category {
    private String name;
    private Optional<CategoryType> CategoryType;


    public Category(String name,  Optional<CategoryType> categoryType) {
        this.name = name;
        this.CategoryType = categoryType;
    }
}