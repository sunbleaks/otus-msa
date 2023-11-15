package com.example.authservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "auth_roles")
public class Role {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "auth_roles_generator"
    )
    @SequenceGenerator(
            name = "auth_roles_generator",
            sequenceName = "auth_roles_id_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

}

