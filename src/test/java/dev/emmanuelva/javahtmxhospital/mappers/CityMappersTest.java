package dev.emmanuelva.javahtmxhospital.mappers;

import dev.emmanuelva.javahtmxhospital.entities.City;
import dev.emmanuelva.javahtmxhospital.models.CityDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityMappersTest {

    @Test
    void toCityDTO() {
        City city = Instancio.create(City.class);
        CityDTO cityDTO = CityMappers.toCityDTO(city);
        assertNotNull(cityDTO);
        assertEquals(city.getId(), cityDTO.getId());
        assertEquals(city.getName(), cityDTO.getName());
        assertEquals(city.getAlias(), cityDTO.getAlias());
        assertEquals(city.getState().getId().toString(), cityDTO.getState().getKey());
        assertEquals(city.getState().getName(), cityDTO.getState().getValue());
    }
}