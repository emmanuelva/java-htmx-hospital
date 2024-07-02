package dev.emmanuelva.javahtmxhospital.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateDTOTest {

    @Test
    void testBuilderReturned() {
        StateDTO.StateDTOBuilder stateDTO = StateDTO.builder();
        assertNotNull(stateDTO);
        assertInstanceOf(StateDTO.StateDTOBuilder.class, stateDTO);
    }
}