package com.bookingHotel.BookingHotel.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.datatransfer.FlavorEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomNewDto {
    private String roomName;
    private Float width;
    private Float height;
    private Integer maxPerson;
    private Integer hotel_roomClassId;
}
