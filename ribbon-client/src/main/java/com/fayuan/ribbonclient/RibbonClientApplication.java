package com.fayuan.ribbonclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class RibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class, args);
    }

    @Bean
    // 开启客户端负载均衡功能
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

