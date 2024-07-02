package dev.emmanuelva.javahtmxhospital.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String zipCode;

    @ManyToOne
    private City city;
}
