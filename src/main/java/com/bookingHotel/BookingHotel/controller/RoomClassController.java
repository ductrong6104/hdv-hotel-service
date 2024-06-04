package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassNewDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.RoomClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomClass")
public class RoomClassController {
    @Autowired
    private final RoomClassService roomClassService;

    public RoomClassController(RoomClassService roomClassService) {
        this.roomClassService = roomClassService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addRoomClass(@RequestBody RoomClassNewDto roomClassNewDto){
        ResponseData responseData = new ResponseData();
        try{
            RoomClass roomClass = roomClassService.addRoomClass(roomClassNewDto);
            responseData.setData(roomClass);
            responseData.setMessage("get success data");
            responseData.setStatus(200);
        }
        catch (Exception e){
            responseData.setMessage("get not success data");
            responseData.setStatus(400);
        }

        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

}
