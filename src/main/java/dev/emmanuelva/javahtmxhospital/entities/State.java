package dev.emmanuelva.javahtmxhospital.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String normalizedName;
    @Nullable
    private String alias;

    @OneToMany(mappedBy = "state")
    private Set<City> cities;
}
