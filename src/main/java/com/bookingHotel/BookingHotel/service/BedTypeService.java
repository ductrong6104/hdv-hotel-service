package com.bookingHotel.BookingHotel.service;

import com.bookingHotel.BookingHotel.dto.bedType.BedTypeNewDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;

public interface BedTypeService {
    public BedType addBedType(BedTypeNewDto bedTypeNewDto);
}
