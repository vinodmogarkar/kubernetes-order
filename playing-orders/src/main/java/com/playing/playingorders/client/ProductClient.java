package com.playing.playingorders.client;

import com.playing.playingorders.dto.response.OrderProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "playing-products", path = "/api/products", url = "${kubernetes.url.api.products:#{null}}")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    ResponseEntity<OrderProductResponse> getProductById(@PathVariable("id") Long id);
}
