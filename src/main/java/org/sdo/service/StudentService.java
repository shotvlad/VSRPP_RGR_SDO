package org.sdo.service;

import org.sdo.entity.Student;

import java.util.List;

public interface StudentService extends Service<Student> {
    List<Student> readBySurname(String surname);
    List<Student> readByPhone(String phone);
    List<Student> readByEmail(String email);
}
