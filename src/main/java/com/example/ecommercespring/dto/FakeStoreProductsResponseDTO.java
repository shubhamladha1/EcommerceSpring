package com.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FakeStoreProductsResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;

}
