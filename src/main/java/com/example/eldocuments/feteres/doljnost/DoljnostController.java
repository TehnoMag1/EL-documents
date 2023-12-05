package com.example.eldocuments.feteres.doljnost;

import com.example.eldocuments.feteres.doljnost.enitites.DoljnostEntity;
import com.example.eldocuments.feteres.doljnost.services.DoljnostService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doljnosti/")
public class DoljnostController {

    private final DoljnostService doljnostService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @SecurityRequirement(name = "bearerAuth")
    private List<DoljnostEntity> getAll() {
        return doljnostService.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @SecurityRequirement(name = "bearerAuth")
    private DoljnostEntity getById(@PathVariable Integer id) {
        return doljnostService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityRequirement(name = "bearerAuth")
    private DoljnostEntity create(@RequestParam String name) {
        return doljnostService.create(name);
    }
}
