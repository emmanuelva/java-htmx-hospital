package dev.emmanuelva.javahtmxhospital.services.location;

import dev.emmanuelva.javahtmxhospital.entities.State;
import dev.emmanuelva.javahtmxhospital.mappers.StateMappers;
import dev.emmanuelva.javahtmxhospital.models.NewStateDTO;
import dev.emmanuelva.javahtmxhospital.models.StateDTO;
import dev.emmanuelva.javahtmxhospital.repositories.StateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StateServiceImpl implements StateService {
    private final StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public Iterable<StateDTO> getAllStates() {
        return stateRepository.findAll().stream().map(StateMappers::stateToDTO).toList();
    }

    @Override
    public StateDTO saveNewState(NewStateDTO state) {
        State newState = State.builder()
                .name(state.getName())
                .alias(state.getAlias())
                .build();
        this.stateRepository.saveAndFlush(newState);
        return StateMappers.stateToDTO(newState);
    }

    @Override
    public StateDTO getStateById(UUID id) {
        Optional<State> state = this.stateRepository.findById(id);
        return state.map(StateMappers::stateToDTO).orElse(null);
    }
}
