package dev.emmanuelva.javahtmxhospital.services.location;

import dev.emmanuelva.javahtmxhospital.models.CityDTO;
import dev.emmanuelva.javahtmxhospital.models.NewCityDTO;

import java.util.UUID;

public interface CityService {
    CityDTO getCityById(UUID id);
    CityDTO saveNewCity(NewCityDTO city);
}
