package com.example.eldocuments.feteres.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrUpdateUserParams {
    private String uKey;
    private String firstName;
    private String lastName;
    private String midName;
}
