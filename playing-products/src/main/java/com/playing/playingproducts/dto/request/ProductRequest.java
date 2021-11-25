package com.playing.playingproducts.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
public class ProductRequest {

    private String name;
    private Double price;
}
