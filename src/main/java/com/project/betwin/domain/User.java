package com.project.betwin.domain;

import com.project.betwin.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal amount;
    private Integer age;

    @Column(unique = true)
    private String cpf;

    private String email;

    public User(UserDTO dto) {
        this.name = dto.name();
        this.amount = dto.amount();
        this.age = dto.age();
        this.cpf = dto.cpf();
        this.email = dto.email();
    }
}
