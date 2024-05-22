package dev.emmanuelva.javahtmxhospital.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class ZipCodeDTO {
    private UUID id;
    private String zipCode;

    private CityDTO cityDTO;
}
