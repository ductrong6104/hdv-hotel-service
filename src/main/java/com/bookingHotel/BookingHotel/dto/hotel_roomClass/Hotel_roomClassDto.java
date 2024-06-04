package com.bookingHotel.BookingHotel.dto.hotel_roomClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel_roomClassDto {
    private Integer roomClassId;
    private Integer roomPrice;
    private Integer hotelId;
}
