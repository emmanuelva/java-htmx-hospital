package dev.emmanuelva.javahtmxhospital.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String normalizedName;
    private String alias;

    @ManyToOne
    private State state;

    @OneToMany
    private Set<ZipCode> zipCodes;
}
