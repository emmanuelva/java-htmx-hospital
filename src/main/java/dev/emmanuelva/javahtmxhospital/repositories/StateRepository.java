package dev.emmanuelva.javahtmxhospital.repositories;

import dev.emmanuelva.javahtmxhospital.domain.State;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StateRepository extends CrudRepository<State, UUID> {
}
