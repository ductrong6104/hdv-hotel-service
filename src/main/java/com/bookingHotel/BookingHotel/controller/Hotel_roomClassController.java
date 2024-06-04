package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.dto.hotel_roomClass.Hotel_roomClassDto;
import com.bookingHotel.BookingHotel.dto.hotel_roomClass.Hotel_roomClassNewRoomDto;
import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassDto;
import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassNewDto;
import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.Hotel_roomClassService;
import com.bookingHotel.BookingHotel.service.serviceImpl.Hotel_roomClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel_roomClass")
public class Hotel_roomClassController {
    @Autowired
    private final Hotel_roomClassService hotel_roomClassService;

    public Hotel_roomClassController(Hotel_roomClassService hotelRoomClassService) {
        hotel_roomClassService = hotelRoomClassService;

    }
    @GetMapping("/roomClassByHotel")
    public ResponseEntity<?> getRoomClassByHotelId(@RequestParam(name = "hotelId") Integer hotelId){
        ResponseData responseData = new ResponseData();
        List<RoomClassDto> roomClasses = hotel_roomClassService.getRoomClassByHotelId(hotelId);
        responseData.setData(roomClasses);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @GetMapping("/hotel_roomClassRoomByHotel")
    public ResponseEntity<?> getHotel_roomClassRoomByHotelId(@RequestParam(name = "hotelId") Integer hotelId){
        ResponseData responseData = new ResponseData();
        List<Hotel_roomClassNewRoomDto> roomClasses = hotel_roomClassService.getHotel_roomClassByHotelId(hotelId);
        responseData.setData(roomClasses);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @GetMapping("/roomClassNotByHotel")
    public ResponseEntity<?> getRoomClassNotByHotelId(@RequestParam(name = "hotelId") Integer hotelId){
        ResponseData responseData = new ResponseData();
        List<RoomClassDto> roomClasses = hotel_roomClassService.getRoomClassNotByHotelId(hotelId);
        responseData.setData(roomClasses);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRoomClassForHotel(@RequestBody Hotel_roomClassDto hotel_roomClassDto){
        ResponseData responseData = new ResponseData();
        Hotel_roomClass roomClasses = hotel_roomClassService.addRoomClassForHotel(hotel_roomClassDto);
        responseData.setData(roomClasses);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
