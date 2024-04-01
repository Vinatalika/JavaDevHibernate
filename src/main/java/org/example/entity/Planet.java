package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planet")
@Data
@NoArgsConstructor
public class Planet {
    @Id
    @NotBlank
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Planet ID must consist only of uppercase letters and digits")
    private String id;

    @Column(name = "planet_name", length = 500)
    @NotBlank
    @Size(min = 1, max = 500)
    private String name;

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
