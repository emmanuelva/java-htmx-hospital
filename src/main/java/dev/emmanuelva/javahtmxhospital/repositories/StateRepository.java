package dev.emmanuelva.javahtmxhospital.repositories;

import dev.emmanuelva.javahtmxhospital.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {
}
