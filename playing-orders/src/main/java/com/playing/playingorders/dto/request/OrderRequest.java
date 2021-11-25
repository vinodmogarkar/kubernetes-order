package com.playing.playingorders.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder
@Data
public class OrderRequest {

    private String dateTime;
    private List<OrderProductRequest> products;

}
