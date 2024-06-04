package com.bookingHotel.BookingHotel.dto.roomClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomClassDto {
    private Integer id;
    private String roomClassName;
}
