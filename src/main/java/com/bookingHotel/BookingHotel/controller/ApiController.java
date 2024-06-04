package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Room;
import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.repository.HotelRepository;
import com.bookingHotel.BookingHotel.service.ApiService;
import com.bookingHotel.BookingHotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@RestController
//@RequestMapping
//public class ApiController {
//    @Autowired
//    private ApiService apiService;
//    private final RoomService roomService;
//
//    public ApiController(RoomService roomService) {
//        this.roomService = roomService;
//
//    }
//
////    @GetMapping("/callApis")
////    public ResponseEntity<?> callApis() {
////        apiService.callApis();
//////        ResponseData responseData = new ResponseData();
//////        responseData.setData(rooms);
////        return ResponseEntity.status(HttpStatus.OK).body("");
////    }
//
//}
