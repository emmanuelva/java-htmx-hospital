package dev.emmanuelva.javahtmxhospital.mappers;

import dev.emmanuelva.javahtmxhospital.entities.ZipCode;
import dev.emmanuelva.javahtmxhospital.models.ZipCodeDTO;

import java.util.AbstractMap;

public class ZipCodeMappers {
    public static ZipCodeDTO zipCodeDTO(ZipCode zipCode) {
        return ZipCodeDTO.builder()
                .id(zipCode.getId())
                .zipCode(zipCode.getZipCode())
                .city(new AbstractMap.SimpleEntry<>(zipCode.getCity().getId().toString(), zipCode.getCity().getName()))
                .build();
    }
}
