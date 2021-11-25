package com.playing.playingproducts.service;

import com.playing.playingproducts.dto.request.ProductRequest;
import com.playing.playingproducts.dto.response.ProductResponse;
import com.playing.playingproducts.entity.ProductEntity;
import com.playing.playingproducts.mapper.ProductMapper;
import com.playing.playingproducts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponse save(ProductRequest productRequest) {
        return ProductMapper.entityToDto(productRepository.save(ProductEntity.builder()
            .name(productRequest.getName())
            .price(productRequest.getPrice()).build()));
    }

    public ProductResponse getById(Long id) throws Exception {
        var productEntity = Optional.of(productRepository.findById(id)
            .orElseThrow(Exception::new));

        return ProductMapper.entityToDto(productEntity.get());
    }
}
