package com.playing.playingorders.mapper;

import com.playing.playingorders.dto.request.OrderProductRequest;
import com.playing.playingorders.entity.OrderItemEntity;

public class OrderItemMapper {

    public static OrderItemEntity dtoToEntity(OrderProductRequest orderProductRequest, Long idOrder) {
        return OrderItemEntity.builder()
            .idOrder(idOrder)
            .idProduct(orderProductRequest.getIdProduct())
            .quantity(orderProductRequest.getQuantity())
            .build();
    }
}
