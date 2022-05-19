package org.sdo.service;

import org.sdo.entity.Task;

import java.util.List;

public interface TaskService extends Service<Task>{
    List<Task> readByInfo(String info);
}
