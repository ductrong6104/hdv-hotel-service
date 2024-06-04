package com.bookingHotel.BookingHotel.entity.single.hotelPart;

import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "roomName")
    private String roomName;
    @ManyToOne
    @JoinColumn(name = "idHotelRoomClass")
    private Hotel_roomClass hotel_roomClass;
    @Column(name = "width")
    private Float width;
    @Column(name = "height")
    private Float height;
    @Column(name = "maxPerson")
    private Integer maxPerson;
    @Column(name = "roomStatus")
    private Integer roomStatus;
}
