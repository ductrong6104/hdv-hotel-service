package com.bookingHotel.BookingHotel.service;


import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassNewDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;

import java.util.List;

public interface RoomClassService {
    public List<RoomClass> getRoomClassByHotelId(Integer hotelId);
    public RoomClass addRoomClass(RoomClassNewDto roomClassNewDto);
}
