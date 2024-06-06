package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.dto.roomClass_bedType.RoomClass_bedTypeDto;
import com.bookingHotel.BookingHotel.entity.manyToMany.Hotel_roomClass;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.repository.HotelRepository;
import com.bookingHotel.BookingHotel.repository.Hotel_roomClassRepository;
import com.bookingHotel.BookingHotel.repository.RoomClass_bedTypeRepository;
import com.bookingHotel.BookingHotel.service.RoomClass_bedTypeService;

import com.bookingHotel.BookingHotel.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoomClass_bedTypeServiceImpl implements RoomClass_bedTypeService {
    @Autowired
    private final RoomClass_bedTypeRepository roomClass_bedTypeRepository;


    public RoomClass_bedTypeServiceImpl(RoomClass_bedTypeRepository roomClass_bedTypeRepository) {
        this.roomClass_bedTypeRepository = roomClass_bedTypeRepository;

    }

    @Transactional(readOnly = true)
    @Override
    public List<BedType> getBedTypeByHotelId(Integer hotelId) {
        List<Object[]> results = roomClass_bedTypeRepository.getBedTypesByHotelId(hotelId);
        String[] fields = {"id", "bedTypeName"};
        return MapperUtil.mapResults(results, BedType.class, fields);
    }

    @Override
    public List<BedType> getBedTypeNotByHotelId(Integer hotelId) {

        return List.of();
    }
}
