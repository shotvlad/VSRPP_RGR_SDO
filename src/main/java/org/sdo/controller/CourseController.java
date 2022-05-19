package org.sdo.controller;

import org.sdo.entity.Course;
import org.sdo.service.CourseService;
import org.sdo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/course")
public class CourseController extends AbstractController<Course> {
    @Autowired
    private CourseService service;

    @Override
    public CourseService getService() {
        return service;
    }

    @GetMapping("/price/{begin}-{end}")
    public ResponseEntity<List<Course>> getByPrice(@PathVariable double begin, @PathVariable double end) {
        List<Course> courses = service.readByPrice(begin, end);
        if (courses.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(courses, headers, HttpStatus.OK);
    }

    @GetMapping("/info/{info}")
    public ResponseEntity<List<Course>> getByInfo(@PathVariable String info) {
        List<Course> courses = service.readByInfo(info);
        if (courses.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(courses, headers, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Course>> getByName(@PathVariable String name) {
        List<Course> courses = service.readByName(name);
        if (courses.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(courses, headers, HttpStatus.OK);
    }
}
