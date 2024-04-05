package dev.emmanuelva.javahtmxhospital.repositories;

import dev.emmanuelva.javahtmxhospital.domain.City;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CityRepository extends CrudRepository<City, UUID> {
}
