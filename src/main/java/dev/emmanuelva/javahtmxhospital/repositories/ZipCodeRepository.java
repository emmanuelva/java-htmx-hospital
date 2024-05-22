package dev.emmanuelva.javahtmxhospital.repositories;

import dev.emmanuelva.javahtmxhospital.entities.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ZipCodeRepository extends JpaRepository<ZipCode, UUID> {
}
