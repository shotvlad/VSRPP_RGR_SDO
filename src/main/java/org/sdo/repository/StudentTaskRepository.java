package org.sdo.repository;

import org.sdo.entity.Student;
import org.sdo.entity.StudentTask;
import org.sdo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentTaskRepository extends JpaRepository<StudentTask, Long> {
    List<StudentTask> findByStatusContaining(String status);
    List<StudentTask> findByStudent(Student student);
    List<StudentTask> findByTask(Task task);
}
