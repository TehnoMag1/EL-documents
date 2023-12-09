package com.example.eldocuments.feteres.user.entities;

import com.example.eldocuments.feteres.doljnost.enitites.DoljnostEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "rashirennya_informacia")
public class UserDetailsInfoEntity {

    @Id
    private Integer id;

    private LocalDate birthday;
    private Integer nPassport;
    private Integer sPassport;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    private DoljnostEntity doljnost;
}
