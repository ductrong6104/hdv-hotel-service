package com.bookingHotel.BookingHotel.service;

import com.bookingHotel.BookingHotel.dto.hotel_roomClass.Hotel_roomClassDto;
import com.bookingHotel.BookingHotel.dto.hotel_roomClass.Hotel_roomClassNewRoomDto;
import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassDto;
import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;

import java.util.List;

public interface Hotel_roomClassService {
    public List<RoomClassDto> getRoomClassByHotelId(Integer hotelId);
    public List<RoomClassDto> getRoomClassNotByHotelId(Integer hotelId);
    public Hotel_roomClass addRoomClassForHotel(Hotel_roomClassDto hotel_roomClassDto);
    public List<Hotel_roomClassNewRoomDto> getHotel_roomClassByHotelId(Integer hotelId);
}
