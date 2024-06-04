package com.bookingHotel.BookingHotel.service;

import com.bookingHotel.BookingHotel.dto.roomClass_bedType.RoomClass_bedTypeDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoomClass_bedTypeService {

    public List<BedType> getBedTypeByHotelId(Integer hotelId);
    public List<BedType> getBedTypeNotByHotelId(Integer hotelId);
}
