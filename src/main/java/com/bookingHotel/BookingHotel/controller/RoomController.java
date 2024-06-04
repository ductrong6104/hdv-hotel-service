package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.dto.room.RoomNewDto;
import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassNewDto;
import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping("/roomsByHotel")
    public ResponseEntity<?> getRoomByHotelId(@RequestParam(name = "hotelId") Integer hotelId){
        System.out.println("\n \n aba\n \n");
        ResponseData responseData = new ResponseData();
        responseData.setMessage("get success data");
        responseData.setStatus(200);
        responseData.setData(roomService.getRoomByHotelId(hotelId));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addNewRoomForHotel(@RequestBody RoomNewDto roomNewDto){
        ResponseData responseData = new ResponseData();
        responseData.setMessage("get success data");
        responseData.setStatus(200);
        responseData.setData(roomService.addNewRoomForHotel(roomNewDto));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}