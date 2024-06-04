package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findByHotelStatus(Integer status);
    List<Hotel> findByHotelierId(Integer hotelierId);
    Optional<Hotel> findById(Integer hotelId);
}
