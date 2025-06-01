package com.microservice.authentication.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String role; // e.g., "ROLE_USER", "ROLE_ADMIN"
}