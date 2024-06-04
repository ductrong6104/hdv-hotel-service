package com.bookingHotel.BookingHotel.entity.single.hotelPart;

import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_addon;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "addon")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
public class Addon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "addonName")
    private String addonName;
    @OneToMany(mappedBy = "addon", fetch = FetchType.EAGER)
    private List<Hotel_addon> hotel_addons;
}
