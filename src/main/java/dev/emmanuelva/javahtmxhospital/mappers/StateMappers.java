package dev.emmanuelva.javahtmxhospital.mappers;

import dev.emmanuelva.javahtmxhospital.entities.State;
import dev.emmanuelva.javahtmxhospital.models.StateDTO;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Collectors;

public class StateMappers {
    public static StateDTO stateToDTO(State state, boolean includeChildren) {
        Map<String, String> cities = null;

        if (includeChildren) {
            cities = state.getCities().stream()
                    .map(city -> new SimpleEntry<>(city.getId().toString(), city.getName()))
                    .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
        }

        return StateDTO.builder()
                .id(state.getId().toString())
                .name(state.getName())
                .alias(state.getAlias())
                .cities(cities)
                .build();
    }

    public static StateDTO stateToDTO(State state) {
        return stateToDTO(state, false);
    }
}
