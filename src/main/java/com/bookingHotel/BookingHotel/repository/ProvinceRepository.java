package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.addressPart.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    public Optional<Province> findById(Integer id);
}
