package com.google.gfx.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class GfxWebApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "web-server");

		SpringApplication.run(GfxWebApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		RestTemplate rt = new RestTemplate();
		rt.setInterceptors(Stream.of(new RequestInterceptor()).collect(Collectors.toList()));
		// This isn't right. Need a way to keep all default converters and only use the Jackson
		// one.
		rt.setMessageConverters(
				Stream.of(new MappingJackson2HttpMessageConverter()).collect(
						Collectors.toList()));

		return rt;
	}
}
