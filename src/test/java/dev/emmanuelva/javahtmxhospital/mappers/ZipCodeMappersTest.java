package dev.emmanuelva.javahtmxhospital.mappers;

import dev.emmanuelva.javahtmxhospital.entities.ZipCode;
import dev.emmanuelva.javahtmxhospital.models.ZipCodeDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeMappersTest {

    @Test
    void testZipCodeDTO() {
        ZipCode zipCode = Instancio.create(ZipCode.class);
        ZipCodeDTO zipCodeDTO = ZipCodeMappers.zipCodeDTO(zipCode);
        assertNotNull(zipCodeDTO);
        assertEquals(zipCode.getId(), zipCodeDTO.getId());
        assertEquals(zipCode.getZipCode(), zipCodeDTO.getZipCode());
        assertEquals(zipCode.getCity().getId().toString(), zipCodeDTO.getCity().getKey());
        assertEquals(zipCode.getCity().getName(), zipCodeDTO.getCity().getValue());
    }
}