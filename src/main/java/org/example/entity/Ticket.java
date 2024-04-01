package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "client_id")
    @NotNull
    private Long clientId;

    @Column(name = "from_planet_id")
    @NotNull
    private Long fromPlanetId;

    @Column(name = "to_planet_id")
    @NotNull
    private Long toPlanetId;
}
