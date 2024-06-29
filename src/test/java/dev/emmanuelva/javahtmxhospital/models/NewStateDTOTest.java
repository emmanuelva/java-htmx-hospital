package dev.emmanuelva.javahtmxhospital.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewStateDTOTest {
    @Test
    void testBuilderNormalizeName() {
        NewStateDTO state = NewStateDTO.builder().name("New Státe").build();
        assertEquals("new state", state.getNormalizedName());
    }
}