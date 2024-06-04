package com.bookingHotel.BookingHotel.entity.manyToMany;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.Addon;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.HotelType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "hotel_addon")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class Hotel_addon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "idAddon")
    private Addon addon;
    @Column(name = "addonPrice")
    private int addonPrice;
}
