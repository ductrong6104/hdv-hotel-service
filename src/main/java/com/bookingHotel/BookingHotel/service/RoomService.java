package com.bookingHotel.BookingHotel.service;

import com.bookingHotel.BookingHotel.dto.room.RoomNewDto;
import com.bookingHotel.BookingHotel.dto.room.RoomResponseDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Room;

import java.util.List;

public interface RoomService {

    public List<Room> getAllRoom();
    public List<RoomResponseDto> getRoomByHotelId(Integer hotelId);
    public Room addNewRoomForHotel(RoomNewDto roomNewDto);
}
