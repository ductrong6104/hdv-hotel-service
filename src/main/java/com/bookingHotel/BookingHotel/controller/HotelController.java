package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.dto.hotel.HotelDto;
import com.bookingHotel.BookingHotel.dto.hotel.HotelNameDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private final HotelService hotelService;


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getHotel(){
        ResponseData responseData = new ResponseData();
        List<Hotel> hotels = hotelService.getAllHotels();
        responseData.setData(hotels);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @GetMapping("/hotelsByHotelier")
    public ResponseEntity<?> getHotelsByHotelierId(@RequestParam(name = "hotelierId") Integer hotelierId){
        ResponseData responseData = new ResponseData();
        List<Hotel> hotels = hotelService.getHotelsByHotelierId(hotelierId);
        responseData.setData(hotels);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @GetMapping("/hotelNameById")
    public ResponseEntity<?> getHotelNameById(@RequestParam(name = "id") Integer id){
        ResponseData responseData = new ResponseData();
        HotelNameDto hotel = hotelService.getHotelNameById(id);
        responseData.setData(hotel);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @GetMapping("/unsucessRegistrationHotels")
    public ResponseEntity<?> getHotelUnsucessRegistration(){
        ResponseData responseData = new ResponseData();
        List<Hotel> hotels = hotelService.getHotelUnsucessRegistration();
        responseData.setData(hotels);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addHotel(@RequestBody HotelDto hotelDto){
        ResponseData responseData = new ResponseData();
        Hotel hotelNew = hotelService.addHotel(hotelDto);
        responseData.setData(hotelNew);
        responseData.setStatus(200);
        responseData.setMessage("get data success");
//        System.out.println("get hotel");
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

}
