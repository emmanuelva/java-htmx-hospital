package dev.emmanuelva.javahtmxhospital.services;

import dev.emmanuelva.javahtmxhospital.entities.State;
import dev.emmanuelva.javahtmxhospital.models.NewStateDTO;
import dev.emmanuelva.javahtmxhospital.models.StateDTO;
import dev.emmanuelva.javahtmxhospital.repositories.StateRepository;
import dev.emmanuelva.javahtmxhospital.services.location.StateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class StateServiceImplTest {
    @Mock
    StateRepository stateRepository;

    StateServiceImpl stateService;

    @BeforeEach
    public void setUp() {
        stateService = new StateServiceImpl(stateRepository);
    }

    @Test
    void getAllStates() {
        State state = State.builder()
                .id(UUID.randomUUID())
                .name("New State")
                .normalizedName("New State")
                .build();
        List<State> stateList = new ArrayList<>();
        stateList.add(state);
        Mockito.when(stateRepository.findAll()).thenReturn(stateList);

        List<StateDTO> states = StreamSupport.stream(stateService.getAllStates().spliterator(), false).toList();
        assertNotNull(states);
    }

    @Test
    void saveNewState() {
        Mockito.when(stateRepository.saveAndFlush(Mockito.any(State.class)))
                .then(invocation -> {
                    Object arg = invocation.getArgument(0);
                    ((State) arg).setId(UUID.randomUUID());
                    return null;
                });

        NewStateDTO stateDTO = NewStateDTO.builder()
                .name("New Státe")
                .build();
        StateDTO savedState = stateService.saveNewState(stateDTO);
        assertNotNull(savedState);
        assertNotNull(savedState.getId());
        assertEquals(savedState.getName(), stateDTO.getName());
        assertNull(savedState.getAlias());
    }

    @Test
    void getStateById() {
        UUID id = UUID.randomUUID();
        State state = State.builder()
                .id(id)
                .name("New State")
                .normalizedName("new state")
                .build();
        Mockito.when(stateRepository.findById(id))
                .thenReturn(Optional.of(state));

        StateDTO stateDTO = stateService.getStateById(id);

        assertNotNull(stateDTO);
        assertNotNull(stateDTO.getId());
        assertEquals(stateDTO.getName(), state.getName());
        assertEquals(stateDTO.getAlias(), state.getAlias());
        assertNull(stateDTO.getAlias());
    }
}