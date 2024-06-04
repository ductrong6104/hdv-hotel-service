package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.addressPart.District;
import com.bookingHotel.BookingHotel.entity.single.addressPart.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
    public List<District> findByProvince(Province province);
    public Optional<District> findById(Integer districtId);
}
