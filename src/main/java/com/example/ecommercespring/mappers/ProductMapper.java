package com.example.ecommercespring.mappers;
import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO productDto){
        return Product.builder()
                .id(productDto.getId())
                .image(productDto.getImage())
                .color(productDto.getColor())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .discount(productDto.getDiscount())
                .model(productDto.getModel())
                .title(productDto.getTitle())
                .category(productDto.getCategory())
                .brand(productDto.getBrand())
                .popular(productDto.isPopular())
                .build();
    }
}
