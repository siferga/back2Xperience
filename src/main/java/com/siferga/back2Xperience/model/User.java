package com.siferga.back2Xperience.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "idService", nullable = false)
    private Service service;


}
