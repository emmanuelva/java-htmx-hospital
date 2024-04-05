package dev.emmanuelva.javahtmxhospital.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String normalizedName;
    private String alias;

    @OneToMany(mappedBy = "state")
    private Set<City> cities;
}
