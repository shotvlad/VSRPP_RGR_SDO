package org.sdo.repository;

import org.sdo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByPriceBetween(double begin, double end);
    List<Course> findByInfoContaining(String info);
    List<Course> findByNameContaining(String name);
}