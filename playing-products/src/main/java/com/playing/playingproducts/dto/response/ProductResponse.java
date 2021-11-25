package com.playing.playingproducts.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
public class ProductResponse {

    private Long id;
    private String name;
    private Double price;
}
