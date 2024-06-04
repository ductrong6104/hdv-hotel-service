package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.manyToMany.RoomClass_bedType;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface RoomClass_bedTypeRepository extends JpaRepository<RoomClass_bedType, Integer> {
    @Procedure(procedureName = "sp_find_bedTypes_by_hotelId")
    public List<Object[]> getBedTypesByHotelId(@Param("hotelId") Integer hotelId);
}
