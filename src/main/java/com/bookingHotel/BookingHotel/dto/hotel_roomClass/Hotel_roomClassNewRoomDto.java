package com.bookingHotel.BookingHotel.dto.hotel_roomClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel_roomClassNewRoomDto {
    // id: hotel_roomClassId
    private Integer id;
    private String roomClassName;
}
