package org.sdo.controller;

import org.sdo.entity.Task;
import org.sdo.service.Service;
import org.sdo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController extends AbstractController<Task> {
    @Autowired
    private TaskService service;

    @Override
    public TaskService getService() {
        return service;
    }

    @GetMapping("/info/{info}")
    public ResponseEntity<List<Task>> getByInfo(@PathVariable String info) {
        List<Task> tasks = service.readByInfo(info);
        if (tasks.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(tasks, headers, HttpStatus.OK);
    }
}
