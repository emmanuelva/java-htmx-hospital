package dev.emmanuelva.javahtmxhospital.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String zipCode;

    @ManyToOne
    private City city;
}
