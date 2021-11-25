package com.playing.playingproducts.mapper;

import com.playing.playingproducts.dto.response.ProductResponse;
import com.playing.playingproducts.entity.ProductEntity;

public class ProductMapper {

    public static ProductResponse entityToDto(ProductEntity productEntity) {
        return ProductResponse.builder()
            .name(productEntity.getName())
            .price(productEntity.getPrice())
            .id(productEntity.getId())
            .build();
    }
}
