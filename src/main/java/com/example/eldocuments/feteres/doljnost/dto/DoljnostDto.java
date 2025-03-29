package com.example.eldocuments.feteres.doljnost.dto;

import com.example.eldocuments.feteres.doljnost.enitites.DoljnostEntity;
import lombok.Data;

@Data
public class DoljnostDto {
    private Integer id;
    private String name;

    public static DoljnostDto create(DoljnostEntity entity) {
        DoljnostDto dto = new DoljnostDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }
}
