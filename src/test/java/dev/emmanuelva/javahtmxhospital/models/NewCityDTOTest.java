package dev.emmanuelva.javahtmxhospital.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewCityDTOTest {
    @Test
    void testBuilderNormalizeName() {
        NewCityDTO city = NewCityDTO.builder().name("New Cíty").build();
        assertEquals("new city", city.getNormalizedName());
    }
}