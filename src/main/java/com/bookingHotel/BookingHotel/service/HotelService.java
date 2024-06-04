package com.bookingHotel.BookingHotel.service;


import com.bookingHotel.BookingHotel.dto.hotel.HotelDto;
import com.bookingHotel.BookingHotel.dto.hotel.HotelNameDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;

import java.util.List;

public interface HotelService {
    public List<Hotel> getHotelUnsucessRegistration();
    public List<Hotel> getAllHotels();
    public Hotel addHotel(HotelDto hotelDto);
    public List<Hotel> getHotelsByHotelierId(Integer hotelierId);
    public HotelNameDto getHotelNameById(Integer id);
}
