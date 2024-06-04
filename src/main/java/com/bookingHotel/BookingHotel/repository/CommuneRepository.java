package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.addressPart.Commune;
import com.bookingHotel.BookingHotel.entity.single.addressPart.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Integer> {
    public List<Commune> findByDistrict(District district);
}
