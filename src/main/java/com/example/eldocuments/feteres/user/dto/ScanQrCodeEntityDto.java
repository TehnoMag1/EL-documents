package com.example.eldocuments.feteres.user.dto;

import com.example.eldocuments.feteres.user.entities.ScanQrCodeEntity;
import lombok.Value;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.eldocuments.feteres.user.entities.ScanQrCodeEntity}
 */
@Value
public class ScanQrCodeEntityDto {
    Integer id;
    UserEntityDto user;
    LocalDate date;

    public ScanQrCodeEntityDto(ScanQrCodeEntity scanQrCodeEntity) {
        this.id = scanQrCodeEntity.getId();
        this.date = scanQrCodeEntity.getDate();
        this.user = new UserEntityDto(
                scanQrCodeEntity.getId(),
                scanQrCodeEntity.getUser().getFirstName(),
                scanQrCodeEntity.getUser().getMidName(),
                scanQrCodeEntity.getUser().getLastName()
        );
    }

    /**
     * DTO for {@link com.example.eldocuments.feteres.user.entities.UserEntity}
     */
    @Value
    public static class UserEntityDto {
        Integer id;
        String firstName;
        String midName;
        String lastName;
    }
}