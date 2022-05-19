package org.sdo.repository;

import org.sdo.entity.Course;
import org.sdo.entity.Theory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheoryRepository extends JpaRepository<Theory, Long> {
    List<Theory> findByInfoContaining(String info);
    List<Theory> findByNameContaining(String name);
    List<Theory> findByCourse(Course course);
}
