package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.dto.bedType.BedTypeNewDto;
import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassNewDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.BedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bedType")
public class BedTypeController {
    @Autowired
    private final BedTypeService bedTypeService;

    public BedTypeController(BedTypeService bedTypeService) {
        this.bedTypeService = bedTypeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBedType(@RequestBody BedTypeNewDto bedTypeNewDto){
        ResponseData responseData = new ResponseData();
        try{
            BedType roomClass = bedTypeService.addBedType(bedTypeNewDto);
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
