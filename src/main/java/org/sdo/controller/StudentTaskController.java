package org.sdo.controller;

import org.sdo.entity.Student;
import org.sdo.entity.StudentTask;
import org.sdo.entity.Task;
import org.sdo.service.Service;
import org.sdo.service.StudentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/studenttask")
public class StudentTaskController extends AbstractController<StudentTask> {
    @Autowired
    private StudentTaskService service;

    @Override
    public StudentTaskService getService() {
        return service;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<StudentTask>> getByStatus(@PathVariable String status) {
        List<StudentTask> studentTasks = service.readByStatus(status);
        if (studentTasks.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(studentTasks, headers, HttpStatus.OK);
    }

    @GetMapping("/student/{student}")
    public ResponseEntity<List<StudentTask>> getByStudent(@PathVariable Student student) {
        List<StudentTask> studentTasks = service.readByStudent(student);
        if (studentTasks.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(studentTasks, headers, HttpStatus.OK);
    }

    @GetMapping("/task/{task}")
    public ResponseEntity<List<StudentTask>> getByTask(@PathVariable Task task) {
        List<StudentTask> studentTasks = service.readByTask(task);
        if (studentTasks.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(studentTasks, headers, HttpStatus.OK);
    }
}
