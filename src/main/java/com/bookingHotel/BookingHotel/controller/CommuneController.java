package com.bookingHotel.BookingHotel.controller;

import com.bookingHotel.BookingHotel.payload.ResponseData;
import com.bookingHotel.BookingHotel.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commune")
public class CommuneController {
    @Autowired
    private final CommuneService communeService;

    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllCommunes(){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get communes sucesss");
        responseData.setData(communeService.getAllCommune());
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
    @GetMapping("/communeOfDistrict")
    public ResponseEntity<?> getCommuneByDistrictId(@RequestParam(name = "districtId") Integer districtId){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("get province sucesss");
        responseData.setData(communeService.getCommuneByDistrictId(districtId));
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
