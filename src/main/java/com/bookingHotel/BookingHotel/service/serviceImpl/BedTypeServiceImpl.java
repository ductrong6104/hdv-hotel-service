package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.dto.bedType.BedTypeNewDto;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.BedType;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.RoomClass;
import com.bookingHotel.BookingHotel.repository.BedTypeRepository;
import com.bookingHotel.BookingHotel.service.BedTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedTypeServiceImpl implements BedTypeService {
    @Autowired
    private final BedTypeRepository bedTypeRepository;
    private final ModelMapper modelMapper;

    public BedTypeServiceImpl(BedTypeRepository bedTypeRepository, ModelMapper modelMapper) {
        this.bedTypeRepository = bedTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BedType addBedType(BedTypeNewDto bedTypeNewDto) {
        BedType bedType = modelMapper.map(bedTypeNewDto, BedType.class);
        try{
            return bedTypeRepository.save(bedType);
        }
        catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }

    }
}
