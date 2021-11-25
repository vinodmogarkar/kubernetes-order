package com.playing.playingorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.playing.playingorders")
public class PlayingOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayingOrdersApplication.class, args);
	}

}
