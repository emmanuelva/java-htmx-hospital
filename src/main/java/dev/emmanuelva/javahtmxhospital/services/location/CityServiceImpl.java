package dev.emmanuelva.javahtmxhospital.services.location;

import dev.emmanuelva.javahtmxhospital.entities.City;
import dev.emmanuelva.javahtmxhospital.entities.State;
import dev.emmanuelva.javahtmxhospital.mappers.CityMappers;
import dev.emmanuelva.javahtmxhospital.models.CityDTO;
import dev.emmanuelva.javahtmxhospital.models.NewCityDTO;
import dev.emmanuelva.javahtmxhospital.repositories.CityRepository;
import dev.emmanuelva.javahtmxhospital.repositories.StateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final StateRepository stateRepository;

    public CityServiceImpl(CityRepository cityRepository, StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public CityDTO getCityById(UUID id) {
        Optional<City> city = cityRepository.findById(id);
        return city.map(CityMappers::toCityDTO).orElse(null);
    }

    @Override
    public CityDTO saveNewCity(NewCityDTO city) {
        UUID stateId = UUID.fromString(city.getState().getId());
        Optional<State> state = stateRepository.findById(stateId);
        if (state.isEmpty()) {
            throw new RuntimeException("State not found.");
        }
        City newCity = City.builder()
                .name(city.getName())
                .normalizedName(city.getNormalizedName())
                .alias(city.getAlias())
                .state(state.get())
                .build();
        this.cityRepository.saveAndFlush(newCity);

        return CityMappers.toCityDTO(newCity);
    }
}
