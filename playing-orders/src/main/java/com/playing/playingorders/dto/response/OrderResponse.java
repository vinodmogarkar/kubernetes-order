package com.playing.playingorders.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Jacksonized
@Builder
@Data
public class OrderResponse {

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm", shape = Shape.STRING)
    private LocalDateTime dateTime;
    private Double amount;

}
