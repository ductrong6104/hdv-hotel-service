package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.BedTypeService;
import com.bookingHotel.BookingHotel.service.RoomClass_bedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roomClass_bedType")
public class RoomClass_bedTypeController {
    @Autowired
    private final RoomClass_bedTypeService roomClass_bedTypeService;

    public RoomClass_bedTypeController(RoomClass_bedTypeService roomClassBedTypeService) {
        roomClass_bedTypeService = roomClassBedTypeService;
    }

    @GetMapping("/bedTypesByHotel")
    public ResponseEntity<?> getBedTypeByHotelId(@RequestParam(name = "hotelId") Integer hotelId){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get success data");
        responseData.setData(roomClass_bedTypeService.getBedTypeByHotelId(hotelId));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @GetMapping("/bedTypesNotByHotelAndRoomClass")
    public ResponseEntity<?> getBedTypeNotByHotelIdAndRoomClassId(@RequestParam(name = "hotelId") Integer hotelId){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get success data");
        responseData.setData(roomClass_bedTypeService.getBedTypeNotByHotelId(hotelId));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
