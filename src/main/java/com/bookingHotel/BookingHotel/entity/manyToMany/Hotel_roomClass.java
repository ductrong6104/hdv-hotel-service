package com.bookingHotel.BookingHotel.entity.manyToMany;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Room;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "hotel_roomClass")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class Hotel_roomClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "idRoomClass")
    private RoomClass roomClass;
    @Column(name = "roomPrice")
    private Integer roomPrice;
    @OneToMany(mappedBy = "hotel_roomClass", fetch = FetchType.EAGER)
    private List<RoomClass_bedType> roomClass_bedTypes;
    @OneToMany(mappedBy = "hotel_roomClass", fetch = FetchType.EAGER)
    private List<RoomClass_feature> roomClass_features;

}
