package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.HotelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelTypeRepository extends JpaRepository<HotelType, Integer> {

}
