package com.playing.playingorders.service;


import com.playing.playingorders.client.ProductClient;
import com.playing.playingorders.dto.request.OrderRequest;
import com.playing.playingorders.dto.response.OrderResponse;
import com.playing.playingorders.dto.response.OrderProductResponse;
import com.playing.playingorders.entity.OrderEntity;
import com.playing.playingorders.mapper.OrderItemMapper;
import com.playing.playingorders.mapper.OrderMapper;
import com.playing.playingorders.repository.OrderItemRepository;
import com.playing.playingorders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public OrderResponse save(OrderRequest orderRequest) {
        final Double amount = orderRequest.getProducts().stream()
            .mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();

        final OrderEntity order = orderRepository.save(OrderEntity.builder()
            .dateTime(LocalDateTime.parse(orderRequest.getDateTime()))
            .amount(amount).build());

        orderRequest.getProducts().forEach(item -> orderItemRepository
            .save(OrderItemMapper.dtoToEntity(item, order.getId())));

        return OrderMapper.entityToDto(order);
    }

    public OrderResponse getById(Long id) throws Exception {
        final var productEntity = Optional.of(orderRepository.findById(id)
            .orElseThrow(Exception::new));

        return OrderMapper.entityToDto(productEntity.get());
    }

    public OrderProductResponse getProductById(Long idProduct) throws Exception {
        final var product = productClient.getProductById(idProduct);
        if (Objects.isNull(product)) {
            throw new Exception("Product not found!");
        }
        return product.getBody();
    }

}
