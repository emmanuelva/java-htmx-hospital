package dev.emmanuelva.javahtmxhospital.models;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Builder
@Data
public class CityDTO {
    private UUID id;
    private String name;
    private String normalizedName;
    private String alias;

    private StateDTO state;

    private Set<ZipCodeDTO> zipCodeDTOS;
}
