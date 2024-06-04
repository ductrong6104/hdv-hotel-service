package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.DistrictService;
import com.bookingHotel.BookingHotel.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private final DistrictService districtService;


    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDistricts(){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get province sucesss");
        responseData.setData(districtService.getALlDistricts());
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @GetMapping("/districtOfProvince")
    public ResponseEntity<?> getDistrictByProvinceId(@RequestParam(name = "provinceId") Integer provinceId){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get province sucesss");
        responseData.setData(districtService.getDistrictByProvinceId(provinceId));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
