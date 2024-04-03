package ch3.pertemuan2;


import lombok.Data;

import java.util.Optional;

@Data
public class DetailProduct {
    private String description;
    private Optional<Category> category;

    public DetailProduct(String description, Optional<Category> category) {
        this.description = description;
        this.category = category;
    }
}