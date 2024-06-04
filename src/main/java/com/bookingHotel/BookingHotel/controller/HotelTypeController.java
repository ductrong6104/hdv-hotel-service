package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.HotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotelType")
public class HotelTypeController {
    @Autowired
    private final HotelTypeService hotelTypeService;

    public HotelTypeController(HotelTypeService hotelTypeService) {
        this.hotelTypeService = hotelTypeService;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllHotelTypes(){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get province sucesss");
        responseData.setData(hotelTypeService.getAllHotelTypes());
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
