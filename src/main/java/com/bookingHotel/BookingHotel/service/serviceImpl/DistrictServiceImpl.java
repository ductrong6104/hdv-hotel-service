package com.bookingHotel.BookingHotel.service.serviceImpl;

import com.bookingHotel.BookingHotel.entity.single.addressPart.District;
import com.bookingHotel.BookingHotel.entity.single.addressPart.Province;
import com.bookingHotel.BookingHotel.repository.DistrictRepository;
import com.bookingHotel.BookingHotel.repository.ProvinceRepository;
import com.bookingHotel.BookingHotel.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private final DistrictRepository districtRepository;
    private final ProvinceRepository provinceRepository;

    public DistrictServiceImpl(DistrictRepository districtRepository, ProvinceRepository provinceRepository) {
        this.districtRepository = districtRepository;
        this.provinceRepository = provinceRepository;
    }

    @Override
    public List<District> getALlDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public List<District> getDistrictByProvinceId(Integer provinceId) {
        Optional<Province> provinceOptional = provinceRepository.findById(provinceId);
        List<District> districts = new ArrayList<>();
        if (provinceOptional.isPresent())
            districts = districtRepository.findByProvince(provinceOptional.get());
        return districts;
    }
}
