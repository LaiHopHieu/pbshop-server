package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO extends RepresentationModel<CategoryDTO> {
    private int id;

    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate updatedDate;

    private List<ProductDTO> products;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ProductDTO extends RepresentationModel<ProductDTO> {
        @JsonProperty("productId")
        private int id;
        private String name;
        private LocalDate createdDate;
        private LocalDate updatedDate;
        private double price;
        private double salePrice;
        private String ram;
        private String description;
        private String thumbnailUrl;
    }
}
