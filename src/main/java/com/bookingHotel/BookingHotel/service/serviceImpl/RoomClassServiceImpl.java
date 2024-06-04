package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.dto.roomClass.RoomClassNewDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import com.bookingHotel.BookingHotel.repository.RoomClassRepository;
import com.bookingHotel.BookingHotel.service.RoomClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomClassServiceImpl implements RoomClassService {
    @Autowired
    private final RoomClassRepository roomClassRepository;
    private final ModelMapper modelMapper;

    public RoomClassServiceImpl(RoomClassRepository roomClassRepository, ModelMapper modelMapper) {
        this.roomClassRepository = roomClassRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RoomClass> getRoomClassByHotelId(Integer hotelId) {
        return List.of();
    }

    @Override
    public RoomClass addRoomClass(RoomClassNewDto roomClassNewDto) {
        RoomClass roomClass = modelMapper.map(roomClassNewDto, RoomClass.class);
        try{
            return roomClassRepository.save(roomClass);
        }
        catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }

    }
}
