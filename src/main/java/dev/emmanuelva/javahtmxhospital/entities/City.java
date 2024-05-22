package dev.emmanuelva.javahtmxhospital.entities;

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
