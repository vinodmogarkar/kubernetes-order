package com.playing.playingorders.mapper;

import com.playing.playingorders.dto.response.OrderResponse;
import com.playing.playingorders.entity.OrderEntity;

public class OrderMapper {

    public static OrderResponse entityToDto(OrderEntity orderEntity) {
        return OrderResponse.builder()
            .dateTime(orderEntity.getDateTime())
            .id(orderEntity.getId())
            .amount(orderEntity.getAmount())
            .build();
    }
}
