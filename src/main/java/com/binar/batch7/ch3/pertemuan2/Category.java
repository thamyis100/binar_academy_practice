package com.binar.batch7.ch3.pertemuan2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private String name;
    private Optional<CategoryType> CategoryType;


}