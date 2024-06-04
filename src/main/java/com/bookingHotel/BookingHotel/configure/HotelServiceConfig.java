package com.bookingHotel.BookingHotel.configure;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HotelServiceConfig {
    @Value("${userservice.base.url}")
    private String userserviceBaseUrl;
    // modelMapper: convert entity to dto automatic depend name property
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
    // khoi tao class WebClient de goi api den micro-service khác
    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(userserviceBaseUrl).build();
    }
    // restTemplate: gọi tới các api chạy bất đồng bộ để hiển thị dữ liệu lên giao diện
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

