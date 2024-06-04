package com.bookingHotel.BookingHotel.entity.manyToMany;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.Feature;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "roomClass_feature")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class RoomClass_feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idFeature")
    private Feature feature;
    @ManyToOne
    @JoinColumn(name = "idHotelRoomClass")
    private Hotel_roomClass hotel_roomClass;
}
