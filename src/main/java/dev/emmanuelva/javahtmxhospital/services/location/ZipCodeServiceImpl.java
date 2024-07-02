package dev.emmanuelva.javahtmxhospital.services.location;

import dev.emmanuelva.javahtmxhospital.entities.City;
import dev.emmanuelva.javahtmxhospital.entities.ZipCode;
import dev.emmanuelva.javahtmxhospital.mappers.ZipCodeMappers;
import dev.emmanuelva.javahtmxhospital.models.ZipCodeDTO;
import dev.emmanuelva.javahtmxhospital.repositories.CityRepository;
import dev.emmanuelva.javahtmxhospital.repositories.ZipCodeRepository;

import java.util.Optional;
import java.util.UUID;

public class ZipCodeServiceImpl implements ZipCodeService {
    private final ZipCodeRepository zipCodeRepository;
    private final CityRepository cityRepository;

    public ZipCodeServiceImpl(ZipCodeRepository zipCodeRepository, CityRepository cityRepository) {
        this.zipCodeRepository = zipCodeRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public ZipCodeDTO getZipCode(String zipCode) {
        ZipCode zipCodeObj = zipCodeRepository.findByZipCode(zipCode);
        return ZipCodeMappers.zipCodeDTO(zipCodeObj);
    }

    @Override
    public ZipCodeDTO saveNewZipCode(ZipCodeDTO zipCodeDTO) {
        UUID cityId = UUID.fromString(zipCodeDTO.getZipCode());
        Optional<City> city = cityRepository.findById(cityId);
        if (city.isEmpty()) {
            throw new RuntimeException("City not found");
        }
        ZipCode zipCode = ZipCode.builder()
                .zipCode(zipCodeDTO.getZipCode())
                .city(city.get())
                .build();
        this.zipCodeRepository.saveAndFlush(zipCode);
        return ZipCodeMappers.zipCodeDTO(zipCode);
    }
}
