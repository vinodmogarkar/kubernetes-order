package com.playing.playingorders.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
public class OrderProductRequest {

    private Long idProduct;
    private Integer quantity;
    private Double price;

}
