package com.example.eldocuments.feteres.user.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 48)
    private String firstName;
    @Column(nullable = false, length = 48)
    private String midName;
    @Column(nullable = false, length = 48)
    private String lastName;
    @Column(nullable = false)
    private Boolean isAdmin = false;

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] photo;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private UKeyEntity uKey;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetailsInfoEntity details;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ScanQrCodeEntity> scanQrCodes;
}
