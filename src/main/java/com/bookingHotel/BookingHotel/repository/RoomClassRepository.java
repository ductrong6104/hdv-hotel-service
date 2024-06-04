package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomClassRepository extends JpaRepository<RoomClass, Integer> {
}
