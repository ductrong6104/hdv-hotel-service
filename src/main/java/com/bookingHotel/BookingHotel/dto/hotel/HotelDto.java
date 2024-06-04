package com.bookingHotel.BookingHotel.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelDto {
    private Integer id;
    private Integer hotelTypeId;
    private Integer communeId;
    private Integer hotelierId;
    private String hotelName;
    private String description;
    private String phoneNumber;
    private String checkinTime;
    private String checkoutTime;
    private Integer floorNumber;
    private Integer hotelStatus;
}
