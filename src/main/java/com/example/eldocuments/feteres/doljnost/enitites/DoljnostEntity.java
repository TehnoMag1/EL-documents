package com.example.eldocuments.feteres.doljnost.enitites;

import com.example.eldocuments.feteres.user.entities.UserDetailsInfoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "doljnosti")
public class DoljnostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 48)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doljnost")
    private List<UserDetailsInfoEntity> users;
}
