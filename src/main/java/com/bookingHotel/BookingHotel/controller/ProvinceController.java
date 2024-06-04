package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("province")
public class ProvinceController {
    @Autowired
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllProvince(){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get success sucesss");
        responseData.setData(provinceService.getAllProvince());
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
