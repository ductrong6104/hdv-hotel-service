package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.dto.hotel_roomClass.Hotel_roomClassDto;
import com.bookingHotel.BookingHotel.dto.hotel_roomClass.Hotel_roomClassNewRoomDto;
import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassDto;
import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import com.bookingHotel.BookingHotel.repository.HotelRepository;
import com.bookingHotel.BookingHotel.repository.Hotel_roomClassRepository;
import com.bookingHotel.BookingHotel.repository.RoomClassRepository;
import com.bookingHotel.BookingHotel.service.Hotel_roomClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Hotel_roomClassServiceImpl implements Hotel_roomClassService {
    @Autowired
    private final Hotel_roomClassRepository hotel_roomClassRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final RoomClassRepository roomClassRepository;

    public Hotel_roomClassServiceImpl(Hotel_roomClassRepository hotelRoomClassRepository, HotelRepository hotelRepository, ModelMapper modelMapper, RoomClassRepository roomClassRepository) {
        hotel_roomClassRepository = hotelRoomClassRepository;
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;
        this.roomClassRepository = roomClassRepository;
    }

    @Override
    public List<RoomClassDto> getRoomClassByHotelId(Integer hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if (hotel.isEmpty())
            return null;
        List<Hotel_roomClass> hotelRoomClasses = hotel_roomClassRepository.findByHotel(hotel.get());
        List<RoomClassDto> roomClassDtos = new ArrayList<>();
        hotelRoomClasses.forEach((hotelRoomClass -> {
            RoomClassDto roomClassDto = modelMapper.map(hotelRoomClass.getRoomClass(), RoomClassDto.class);
            roomClassDtos.add(roomClassDto);
        }));
        return roomClassDtos;
    }

    @Override
    public List<RoomClassDto> getRoomClassNotByHotelId(Integer hotelId) {
        List<RoomClass> roomClasses = hotel_roomClassRepository.findByNotInHotel(hotelId);
//        System.out.println("size roomclass not in hotel: " + roomClasses.size());
        List<RoomClassDto> roomClassDtos = new ArrayList<>();
        roomClasses.forEach((roomClass -> {
            RoomClassDto roomClassDto = modelMapper.map(roomClass, RoomClassDto.class);
            roomClassDtos.add(roomClassDto);
        }));
        return roomClassDtos;

    }

    @Override
    public Hotel_roomClass addRoomClassForHotel(Hotel_roomClassDto hotel_roomClassDto) {
        Optional<Hotel> hotel = hotelRepository.findById(hotel_roomClassDto.getHotelId());
        Optional<RoomClass> roomClass = roomClassRepository.findById(hotel_roomClassDto.getRoomClassId());
        if (hotel.isEmpty() || roomClass.isEmpty())
            return null;
        Hotel_roomClass hotelRoomClass = Hotel_roomClass.builder()
                .hotel(hotel.get())
                .roomClass(roomClass.get())
                .roomPrice(hotel_roomClassDto.getRoomPrice())
                .build();
        return hotel_roomClassRepository.save(hotelRoomClass);
    }

    @Override
    public List<Hotel_roomClassNewRoomDto> getHotel_roomClassByHotelId(Integer hotelId) {
        Optional<Hotel> hotel = hotelRepository.findById(hotelId);
        if (hotel.isEmpty())
            return null;
        List<Hotel_roomClass> hotelRoomClasses = hotel_roomClassRepository.findByHotel(hotel.get());
        List<Hotel_roomClassNewRoomDto> hotelRoomClassNewRoomDtos = new ArrayList<>();
        hotelRoomClasses.forEach((hotelRoomClass -> {
            Hotel_roomClassNewRoomDto hotelRoomClassNewRoomDto = new Hotel_roomClassNewRoomDto();
            hotelRoomClassNewRoomDto.setId(hotelRoomClass.getId());
            hotelRoomClassNewRoomDto.setRoomClassName(hotelRoomClass.getRoomClass().getRoomClassName());
            hotelRoomClassNewRoomDtos.add(hotelRoomClassNewRoomDto);
        }));
        return hotelRoomClassNewRoomDtos;
    }
}
