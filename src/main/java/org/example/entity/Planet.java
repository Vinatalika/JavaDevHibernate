package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planet")
@Data
@NoArgsConstructor
public class Planet {
    @Id
    @Column(name = "id")
    @NotBlank
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Planet ID must consist only of uppercase letters and digits")
    private String id;

    @Column(name = "planet_name", length = 500)
    @NotBlank
    @Size(min = 1, max = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet")
    private List<Ticket> outgoingTickets = new ArrayList<>();

    @OneToMany(mappedBy = "toPlanet")
    private List<Ticket> incomingTickets = new ArrayList<>();

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
