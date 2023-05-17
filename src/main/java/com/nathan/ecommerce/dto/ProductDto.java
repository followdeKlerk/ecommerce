package com.nathan.ecommerce.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String imageURL;
    @NotNull
    private double price;
    @NotNull
    private String description;
    @NotNull
    private Integer categoryId;

}
