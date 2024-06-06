package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.dto.room.RoomNewDto;
import com.bookingHotel.BookingHotel.dto.room.RoomResponseDto;
import com.bookingHotel.BookingHotel.dto.room.RoomResponseEditDto;
import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Room;
import com.bookingHotel.BookingHotel.repository.HotelRepository;
import com.bookingHotel.BookingHotel.repository.Hotel_roomClassRepository;
import com.bookingHotel.BookingHotel.repository.RoomRepository;
import com.bookingHotel.BookingHotel.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final Hotel_roomClassRepository hotel_roomClassRepository;


    public RoomServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository, ModelMapper modelMapper, Hotel_roomClassRepository hotelRoomClassRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;

        hotel_roomClassRepository = hotelRoomClassRepository;
    }

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public List<RoomResponseDto> getRoomByHotelId(Integer hotelId) {
        List<Room> rooms = roomRepository.findByHotelId(hotelId);
        List<RoomResponseDto> roomResponseDtos = new ArrayList<>();
        rooms.forEach((room) -> {
            RoomResponseDto roomResponseDto = modelMapper.map(room, RoomResponseDto.class);
            // co id chi tiet khach san, truy van lay ra ten hang phong
            roomResponseDto.setRoomClassName(room.getHotel_roomClass().getRoomClass().getRoomClassName());
            roomResponseDtos.add(roomResponseDto);

        });
        // sap xep theo field roomClassName
        roomResponseDtos.sort(Comparator.comparing(RoomResponseDto::getRoomClassName));
        return roomResponseDtos;
    }

    @Override
    public Room addNewRoomForHotel(RoomNewDto roomNewDto) {
        Optional<Hotel_roomClass> hotelRoomClass = hotel_roomClassRepository.findById(roomNewDto.getHotel_roomClassId());
        if (hotelRoomClass.isEmpty())
            return null;

        Room room = modelMapper.map(roomNewDto, Room.class);
        room.setHotel_roomClass(hotelRoomClass.get());
        // dam bao id cua room la null mới thêm mới record trong db
        room.setId(null);
        room.setRoomStatus(1);
        return roomRepository.save(room);
    }

    @Override
    public RoomResponseEditDto getRoomById(Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isEmpty())
            return null;
        Room room = roomOptional.get();
        RoomResponseEditDto roomResponseEditDto = modelMapper.map(room, RoomResponseEditDto.class);
        return roomResponseEditDto;
    }

    @Override
    public Room editRoom(RoomResponseEditDto roomResponseEditDto) {
        Optional<Hotel_roomClass> hotelRoomClass = hotel_roomClassRepository.findById(roomResponseEditDto.getHotel_roomClassId());
        if (hotelRoomClass.isEmpty())
            return null;

        Room room = modelMapper.map(roomResponseEditDto, Room.class);
        room.setHotel_roomClass(hotelRoomClass.get());
        // dam bao id cua room la null mới thêm mới record trong db
        return roomRepository.save(room);
    }

    @Override
    public List<RoomResponseDto> getRoomsByHotelIdAndMaxPerson(Integer hotelId, Integer maxPerson) {
        List<Room> rooms = roomRepository.findByHotelIdAndMaxPerson(hotelId, maxPerson);
        List<RoomResponseDto> roomResponseDtos = rooms
                .stream()
                        .map(room -> modelMapper.map(room, RoomResponseDto.class))
                                .collect(Collectors.toList());

        return roomResponseDtos;
    }
}
