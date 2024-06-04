package com.bookingHotel.BookingHotel.entity.manyToMany;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "roomClass_bedType")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class RoomClass_bedType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idHotelRoomClass")
    private Hotel_roomClass hotel_roomClass;
    @ManyToOne
    @JoinColumn(name = "idBedType")
    private BedType bedType;
    @Column(name = "number")
    private Integer number;
}
