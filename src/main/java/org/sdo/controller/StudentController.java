package org.sdo.controller;

import org.sdo.entity.Student;
import org.sdo.service.Service;
import org.sdo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController extends AbstractController<Student> {
    @Autowired
    private StudentService service;

    @Override
    public StudentService getService() {
        return service;
    }

    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<Student>> getBySurname(@PathVariable String surname) {
        List<Student> students = service.readBySurname(surname);
        if (students.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(students, headers, HttpStatus.OK);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<List<Student>> getByPhone(@PathVariable String phone) {
        List<Student> students = service.readByPhone(phone);
        if (students.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(students, headers, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Student>> getByEmail(@PathVariable String email) {
        List<Student> students = service.readByEmail(email);
        if (students.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(students, headers, HttpStatus.OK);
    }
}
