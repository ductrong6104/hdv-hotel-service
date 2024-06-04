package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.dto.hotel.HotelDto;
import com.bookingHotel.BookingHotel.dto.hotel.HotelNameDto;
import com.bookingHotel.BookingHotel.entity.single.addressPart.Commune;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.Hotel;
import com.bookingHotel.BookingHotel.entity.single.hotelPart.HotelType;
import com.bookingHotel.BookingHotel.repository.CommuneRepository;
import com.bookingHotel.BookingHotel.repository.HotelRepository;
import com.bookingHotel.BookingHotel.repository.HotelTypeRepository;
import com.bookingHotel.BookingHotel.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private final HotelRepository hotelRepository;
    private final CommuneRepository communeRepository;
    private final HotelTypeRepository hotelTypeRepository;
    private final ModelMapper modelMapper;

    public HotelServiceImpl(HotelRepository hotelRepository, CommuneRepository communeRepository, HotelTypeRepository hotelTypeRepository, ModelMapper modelMapper) {
        this.hotelRepository = hotelRepository;
        this.communeRepository = communeRepository;
        this.hotelTypeRepository = hotelTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Hotel> getHotelUnsucessRegistration() {
        List<Hotel> hotelsUnsuccessRegis = hotelRepository.findByHotelStatus(2);
        return hotelsUnsuccessRegis;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel addHotel(HotelDto hotelDto) {
        Optional<Commune> commune = communeRepository.findById(hotelDto.getCommuneId());
        Optional<HotelType> hotelType = hotelTypeRepository.findById(hotelDto.getHotelTypeId());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setHotelStatus(1);

        Hotel hotelNew = hotelRepository.save(hotel);
        return hotelNew;
    }

    @Override
    public List<Hotel> getHotelsByHotelierId(Integer hotelierId) {
        return hotelRepository.findByHotelierId(hotelierId);
    }

    @Override
    public HotelNameDto getHotelNameById(Integer id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isEmpty())
            return null;
        HotelNameDto hotelName = modelMapper.map(hotelOptional.get(), HotelNameDto.class);
        return hotelName;
    }
}
