package org.sdo.service.impl;

import org.sdo.entity.Course;
import org.sdo.repository.CourseRepository;
import org.sdo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository repository;

    @Override
    public Course read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Course> read() {
        return repository.findAll();
    }

    @Override
    public void save(Course entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Course entity) {
        Course course = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        course.setInfo(entity.getInfo());
        course.setName(entity.getName());
        course.setPrice(entity.getPrice());
        course.setStudents(entity.getStudents());
        course.setTheories(entity.getTheories());
        course.setStatusDate(entity.getStatusDate());
        repository.save(course);
    }

    @Override
    public List<Course> readByPrice(double begin, double end) {
        return repository.findByPriceBetween(begin, end);
    }

    @Override
    public List<Course> readByInfo(String info) {
        return repository.findByInfoContaining(info);
    }

    @Override
    public List<Course> readByName(String name) {
        return repository.findByNameContaining(name);
    }
}
