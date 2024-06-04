package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT m FROM Room m " +
            "WHERE m.hotel_roomClass.id IN (SELECT hrc.id from Hotel_roomClass hrc WHERE hrc.hotel.id = ?1)")
    public List<Room> findByHotelId(Integer hotelId);
}
