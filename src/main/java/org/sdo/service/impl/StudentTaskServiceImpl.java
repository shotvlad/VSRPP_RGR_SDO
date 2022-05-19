package org.sdo.service.impl;

import org.sdo.entity.Student;
import org.sdo.entity.StudentTask;
import org.sdo.entity.Task;
import org.sdo.repository.StudentTaskRepository;
import org.sdo.service.StudentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTaskServiceImpl implements StudentTaskService {
    @Autowired
    private StudentTaskRepository repository;

    @Override
    public StudentTask read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<StudentTask> read() {
        return repository.findAll();
    }

    @Override
    public void save(StudentTask entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(StudentTask entity) {
        StudentTask studentTask = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        studentTask.setStudent(entity.getStudent());
        studentTask.setTask(entity.getTask());
        studentTask.setStatusDate(entity.getStatusDate());
        studentTask.setStatus(entity.getStatus());
        repository.save(studentTask);
    }

    @Override
    public List<StudentTask> readByStatus(String status) {
        return repository.findByStatusContaining(status);
    }

    @Override
    public List<StudentTask> readByStudent(Student student) {
        return repository.findByStudent(student);
    }

    @Override
    public List<StudentTask> readByTask(Task task) {
        return repository.findByTask(task);
    }
}
