package com.example.eldocuments.feteres.doljnost.enitites;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "doljnosti")
public class DoljnostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 48)
    private String name;
}
