package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedTypeRepository extends JpaRepository<BedType, Integer> {
}
