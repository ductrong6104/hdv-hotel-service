package com.bookingHotel.BookingHotel.entity.single.hotelPart;

import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.bookingHotel.BookingHotel.entity.manyToMany.RoomClass_feature;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.awt.desktop.FilesEvent;
import java.util.List;

@Entity
@Table(name = "roomClass")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class RoomClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "roomClassName")
    private String roomClassName;
    @OneToMany(mappedBy = "roomClass", fetch = FetchType.LAZY)
    private List<Hotel_roomClass> hotel_roomClasses;
}
