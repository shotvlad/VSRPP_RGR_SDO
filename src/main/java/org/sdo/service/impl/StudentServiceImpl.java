package org.sdo.service.impl;

import org.sdo.entity.Student;
import org.sdo.repository.StudentRepository;
import org.sdo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public Student read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Student> read() {
        return repository.findAll();
    }

    @Override
    public void save(Student entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Student entity) {
        Student student = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        student.setStudentTask(entity.getStudentTask());
        student.setCourse(entity.getCourse());
        student.setEmail(entity.getEmail());
        student.setName(entity.getName());
        student.setPatronymic(entity.getPatronymic());
        student.setPhone(entity.getPhone());
        student.setStatusDate(entity.getStatusDate());
        student.setSurname(entity.getSurname());
        repository.save(student);
    }

    @Override
    public List<Student> readBySurname(String surname) {
        return repository.findBySurnameContaining(surname);
    }

    @Override
    public List<Student> readByPhone(String phone) {
        return repository.findByPhoneContaining(phone);
    }

    @Override
    public List<Student> readByEmail(String email) {
        return repository.findByEmailContaining(email);
    }
}
