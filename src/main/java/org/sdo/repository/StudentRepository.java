package org.sdo.repository;

import org.sdo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findBySurnameContaining(String surname);
    List<Student> findByPhoneContaining(String phone);
    List<Student> findByEmailContaining(String email);
}
