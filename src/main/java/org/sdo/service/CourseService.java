package org.sdo.service;

import org.sdo.entity.Course;

import java.util.List;

public interface CourseService extends Service<Course>{
    List<Course> readByPrice(double begin, double end);
    List<Course> readByInfo(String info);
    List<Course> readByName(String name);
}
