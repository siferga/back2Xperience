package com.siferga.back2Xperience.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    @Column(unique = true, nullable = false)
    private String serviceName;

    @OneToMany(mappedBy = "service")
    private Set<User> users;
}
