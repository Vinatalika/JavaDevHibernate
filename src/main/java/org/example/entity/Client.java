package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "client")
//@Data
//@NoArgsConstructor
//public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматична генерація ID
//    private Long id;
//
//    @Column(name = "name", length = 200)
//    @NotBlank(message = "Name must not be blank")
//    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
//    private String name;
//
//    public Client(String name) {
//        this.name = name;
//    }
//}
@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    @NotBlank(message = "Name must not be blank")
    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
    private String name;

    public Client(String name) {
        this.name = name;
    }
}
