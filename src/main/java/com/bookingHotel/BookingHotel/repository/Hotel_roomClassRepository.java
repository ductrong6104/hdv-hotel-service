package com.bookingHotel.BookingHotel.repository;

import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Hotel_roomClassRepository extends JpaRepository<Hotel_roomClass, Integer> {
    public List<Hotel_roomClass> findByHotel(Hotel hotel);
    @Query("SELECT rc " +
            "FROM RoomClass rc " +
                "WHERE rc.id " + "NOT IN(SELECT hrc.roomClass.id FROM Hotel_roomClass hrc WHERE hrc.hotel.id = ?1)")
    public List<RoomClass> findByNotInHotel(Integer hotelId);
}
