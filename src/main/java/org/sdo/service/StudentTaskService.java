package org.sdo.service;

import org.sdo.entity.Student;
import org.sdo.entity.StudentTask;
import org.sdo.entity.Task;

import java.util.List;

public interface StudentTaskService extends Service<StudentTask> {
    List<StudentTask> readByStatus(String status);
    List<StudentTask> readByStudent(Student student);
    List<StudentTask> readByTask(Task task);
}
