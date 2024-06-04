package com.bookingHotel.BookingHotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class ApiService {
    @Autowired
    private WebClient webClient;
    private RestTemplate restTemplate;
    @Value("${userservice.base.url}")
    private String userserviceBaseUrl;
    public void callApis() {
        // user modelmapper
//        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
        // Gọi API đầu tiên
        String response1 = webClient.get()
                .uri("/hotel/all")
                .retrieve()
                .bodyToMono(String.class).block();
        // Gọi API thứ hai
//        String response2 = webClient.get()
//                .uri("http://localhost:8080/api/hotel/all")
//                .retrieve()
//                .bodyToMono(String.class).block();
        System.out.println(response1);

    }
    // use async
    @Async
    public CompletableFuture<String> getHotelText() {
        String hotelText = restTemplate.getForObject("http://example.com/api/hotel-text", String.class);
        return CompletableFuture.completedFuture(hotelText);
    }
}
