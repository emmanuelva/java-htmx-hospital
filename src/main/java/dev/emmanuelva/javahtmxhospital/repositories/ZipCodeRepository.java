package dev.emmanuelva.javahtmxhospital.repositories;

import dev.emmanuelva.javahtmxhospital.domain.ZipCode;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ZipCodeRepository extends CrudRepository<ZipCode, UUID> {
}
