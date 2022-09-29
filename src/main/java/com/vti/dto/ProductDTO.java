package com.vti.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {
    private int id;
    private String name;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private double price;
    private double salePrice;
    private String ram;
    private String description;
    private String thumbnailUrl;
    private CategoryDTO category;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CategoryDTO extends RepresentationModel<ProductDTO>{
        private int id;
        private String name;
        private LocalDate createdDate;
        private LocalDate updatedDate;
    }
}
