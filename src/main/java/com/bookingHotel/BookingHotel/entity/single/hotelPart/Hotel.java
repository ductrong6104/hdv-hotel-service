package com.bookingHotel.BookingHotel.entity.single.hotelPart;

import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_addon;
import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.bookingHotel.BookingHotel.entity.single.addressPart.Commune;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idHotelType")
    private HotelType hotelType;
    @ManyToOne
    @JoinColumn(name = "idCommune")
    private Commune commune;
    @Column(name = "hotelName")
    private String hotelName;
    @Column(name = "description")
    private String description;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "checkinTime")
    private String checkinTime;
    @Column(name = "checkoutTime")
    private String checkoutTime;
    @Column(name = "floorNumber")
    private Integer floorNumber;
    @Column(name = "hotelStatus")
    private Integer hotelStatus;
    @Column(name = "idHotelier")
    private Integer hotelierId;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Hotel_addon> hotel_addons;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Hotel_roomClass> hotel_roomClasses;
}
