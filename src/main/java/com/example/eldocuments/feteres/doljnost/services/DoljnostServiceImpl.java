package com.example.eldocuments.feteres.doljnost.services;

import com.example.eldocuments.common.exceptions.NotFoundException;
import com.example.eldocuments.feteres.doljnost.DoljnostRepository;
import com.example.eldocuments.feteres.doljnost.enitites.DoljnostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoljnostServiceImpl implements DoljnostService {

    private final DoljnostRepository doljnostRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DoljnostEntity> getAll() {
        return doljnostRepository.findAll(Sort.by("name"));
    }

    @Override
    @Transactional(readOnly = true)
    public DoljnostEntity getById(Integer id) {
        return doljnostRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doljnost not found"));
    }

    @Override
    @Transactional
    public DoljnostEntity create(String name) {
        DoljnostEntity doljnost = new DoljnostEntity();
        doljnost.setName(name);
        return doljnostRepository.save(doljnost);
    }
}
