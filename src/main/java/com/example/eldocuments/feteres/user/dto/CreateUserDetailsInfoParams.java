package com.example.eldocuments.feteres.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserDetailsInfoParams {

    private LocalDate birthday;
    private String workshopName;
    private String workshopNumber;
    private Integer doljnostId;
}
