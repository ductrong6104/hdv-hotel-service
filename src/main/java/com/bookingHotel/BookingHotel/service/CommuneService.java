package com.bookingHotel.BookingHotel.service;

import com.bookingHotel.BookingHotel.entity.single.addressPart.Commune;

import java.util.List;

public interface CommuneService {
    public List<Commune> getAllCommune();
    public List<Commune> getCommuneByDistrictId(Integer districtId);
}
