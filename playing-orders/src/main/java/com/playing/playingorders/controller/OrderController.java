package com.playing.playingorders.controller;

import com.playing.playingorders.dto.request.OrderRequest;
import com.playing.playingorders.dto.response.OrderResponse;
import com.playing.playingorders.dto.response.OrderProductResponse;
import com.playing.playingorders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.save(orderRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<OrderProductResponse> getProductById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(orderService.getProductById(id));
    }
}
