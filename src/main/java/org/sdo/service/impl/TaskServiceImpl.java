package org.sdo.service.impl;

import org.sdo.entity.Task;
import org.sdo.repository.TaskRepository;
import org.sdo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository repository;

    @Override
    public Task read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Task> read() {
        return repository.findAll();
    }

    @Override
    public void save(Task entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Task entity) {
        Task task = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        task.setInfoTask(entity.getInfoTask());
        task.setStudentTask(entity.getStudentTask());
        task.setStatusDate(entity.getStatusDate());
        task.setTheory(entity.getTheory());
        repository.save(task);
    }

    @Override
    public List<Task> readByInfo(String info) {
        return repository.findByInfoTaskContaining(info);
    }
}
