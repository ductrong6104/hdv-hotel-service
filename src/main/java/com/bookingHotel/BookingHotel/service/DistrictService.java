package com.bookingHotel.BookingHotel.service;

import com.bookingHotel.BookingHotel.entity.single.addressPart.District;

import java.util.List;

public interface DistrictService {
    public List<District> getALlDistricts();
    public List<District> getDistrictByProvinceId(Integer provinceId);
}
