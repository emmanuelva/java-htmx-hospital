package dev.emmanuelva.javahtmxhospital.repositories;

import dev.emmanuelva.javahtmxhospital.entities.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StateRepositoryTest {
    @Autowired
    StateRepository stateRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void testSaveState() {
        State savedState = stateRepository.save(State.builder().name("State Name").normalizedName("state name").build());
        assertThat(savedState).isNotNull();
        assertThat(savedState.getId()).isNotNull();
    }
}