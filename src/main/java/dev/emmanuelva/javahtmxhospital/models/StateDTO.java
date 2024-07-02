package dev.emmanuelva.javahtmxhospital.models;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class StateDTO {
    private String id;
    private String name;
    private String alias;

    private Map<String, String> cities;
}
