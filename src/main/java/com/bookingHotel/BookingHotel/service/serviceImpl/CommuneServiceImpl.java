package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.entity.single.addressPart.Commune;
import com.bookingHotel.BookingHotel.entity.single.addressPart.District;
import com.bookingHotel.BookingHotel.entity.single.addressPart.Province;
import com.bookingHotel.BookingHotel.repository.CommuneRepository;
import com.bookingHotel.BookingHotel.repository.DistrictRepository;
import com.bookingHotel.BookingHotel.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommuneServiceImpl implements CommuneService {
    @Autowired
    private final CommuneRepository communeRepository;
    private final DistrictRepository districtRepository;

    public CommuneServiceImpl(CommuneRepository communeRepository, DistrictRepository districtRepository) {
        this.communeRepository = communeRepository;
        this.districtRepository = districtRepository;
    }

    @Override
    public List<Commune> getAllCommune() {
        return communeRepository.findAll();
    }

    @Override
    public List<Commune> getCommuneByDistrictId(Integer districtId) {
        Optional<District> districtOptional = districtRepository.findById(districtId);
        List<Commune> communes = new ArrayList<>();
        if (districtOptional.isPresent())
            communes = communeRepository.findByDistrict(districtOptional.get());
        return communes;
    }
}
