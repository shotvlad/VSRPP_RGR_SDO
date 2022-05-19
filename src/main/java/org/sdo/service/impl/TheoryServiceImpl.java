package org.sdo.service.impl;

import org.sdo.entity.Theory;
import org.sdo.repository.TheoryRepository;
import org.sdo.service.TheoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheoryServiceImpl implements TheoryService {
    @Autowired
    private TheoryRepository repository;

    @Override
    public Theory read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Theory> read() {
        return repository.findAll();
    }

    @Override
    public void save(Theory entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Theory entity) {
        Theory theory = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        theory.setCourse(entity.getCourse());
        theory.setName(entity.getName());
        theory.setStatusDate(entity.getStatusDate());
        theory.setTask(entity.getTask());
        theory.setInfo(entity.getInfo());
        repository.save(theory);
    }
}
