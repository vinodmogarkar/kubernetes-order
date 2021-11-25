package com.playing.playingorders.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
public class OrderProductResponse {

    private Long id;
    private String name;
    private Double price;

}
