package dev.emmanuelva.javahtmxhospital.models;

import lombok.Builder;
import lombok.Data;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class CityDTO {
    private UUID id;
    private String name;
    private String alias;

    private SimpleEntry<String, String> state;

    private Map<String, String> zipCodes;
}
