package dev.emmanuelva.javahtmxhospital.services.location;

import dev.emmanuelva.javahtmxhospital.models.NewStateDTO;
import dev.emmanuelva.javahtmxhospital.models.StateDTO;

import java.util.UUID;

public interface StateService {
    Iterable<StateDTO> getAllStates();
    StateDTO saveNewState(NewStateDTO stateDTO);
    StateDTO getStateById(UUID id);
}
