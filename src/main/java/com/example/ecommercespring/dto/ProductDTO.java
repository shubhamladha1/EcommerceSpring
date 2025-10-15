package com.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}
