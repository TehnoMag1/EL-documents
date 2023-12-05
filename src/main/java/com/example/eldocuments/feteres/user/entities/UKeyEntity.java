package com.example.eldocuments.feteres.user.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "u_key")
public class UKeyEntity {
    @Id
    private Integer id;

    private String ukey;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
