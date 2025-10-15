package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.FakeStoreProductsResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class FakeStoreProductsGateway implements IProductsGateway {

    private final RestTemplate restTemplate;

    public FakeStoreProductsGateway(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        ResponseEntity<FakeStoreProductsResponseDTO[]> responseEntity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products",
                        FakeStoreProductsResponseDTO[].class
                );

        FakeStoreProductsResponseDTO[] fakeStoreProductsResponseDTO = responseEntity.getBody();
        return Arrays.stream(fakeStoreProductsResponseDTO)
                .map(dto -> ProductDTO.builder()
                        .id(dto.getId())
                        .title(dto.getTitle())
                        .description(dto.getDescription())
                        .price(dto.getPrice())
                        .image(dto.getImage())
                        .category(dto.getCategory())
                        .build())
                .collect(Collectors.toList());
    }
}

