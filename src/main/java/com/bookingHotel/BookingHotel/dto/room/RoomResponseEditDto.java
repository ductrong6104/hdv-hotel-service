package com.bookingHotel.BookingHotel.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomResponseEditDto {
    private Integer id;
    private String roomName;
    private String width;
    private String height;
    private Integer maxPerson;
    private Integer roomStatus;
    private Integer hotel_roomClassId;
}
