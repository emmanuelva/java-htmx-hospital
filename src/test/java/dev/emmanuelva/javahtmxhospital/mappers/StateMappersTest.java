package dev.emmanuelva.javahtmxhospital.mappers;

import dev.emmanuelva.javahtmxhospital.entities.State;
import dev.emmanuelva.javahtmxhospital.models.StateDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateMappersTest {

    @Test
    void stateToDTO() {
        State state = Instancio.create(State.class);
        StateDTO stateDTO = StateMappers.stateToDTO(state);
        assertNotNull(stateDTO);
        assertEquals(state.getId().toString(), stateDTO.getId());
        assertEquals(state.getName(), stateDTO.getName());
        assertEquals(state.getAlias(), stateDTO.getAlias());
        assertNull(stateDTO.getCities());
    }

    @Test
    void testStateToDTOIncludeChildren() {
        State state = Instancio.create(State.class);
        StateDTO stateDTO = StateMappers.stateToDTO(state, true);
        assertNotNull(stateDTO);
        assertEquals(state.getId().toString(), stateDTO.getId());
        assertEquals(state.getName(), stateDTO.getName());
        assertEquals(state.getAlias(), stateDTO.getAlias());
        assertNotNull(stateDTO.getCities());
    }
}