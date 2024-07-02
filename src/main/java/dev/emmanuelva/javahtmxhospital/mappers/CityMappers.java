package dev.emmanuelva.javahtmxhospital.mappers;

import dev.emmanuelva.javahtmxhospital.entities.City;
import dev.emmanuelva.javahtmxhospital.models.CityDTO;

import java.util.AbstractMap.SimpleEntry;

public class CityMappers {
    public static CityDTO toCityDTO(City city) {
        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .alias(city.getAlias())
                .state(new SimpleEntry<>(city.getState().getId().toString(), city.getState().getName()))
                .build();
    }
}
