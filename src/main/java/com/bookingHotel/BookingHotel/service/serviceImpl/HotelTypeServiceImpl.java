package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.entity.single.hotelPart.HotelType;
import com.bookingHotel.BookingHotel.repository.HotelTypeRepository;
import com.bookingHotel.BookingHotel.service.HotelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelTypeServiceImpl implements HotelTypeService {
    @Autowired
    private final HotelTypeRepository hotelTypeRepository;

    public HotelTypeServiceImpl(HotelTypeRepository hotelTypeRepository) {
        this.hotelTypeRepository = hotelTypeRepository;
    }

    @Override
    public List<HotelType> getAllHotelTypes() {
        return hotelTypeRepository.findAll();
    }
}
