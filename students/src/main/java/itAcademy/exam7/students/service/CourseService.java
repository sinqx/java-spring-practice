package itAcademy.exam7.students.service;

import itAcademy.exam7.students.entity.Course;

import java.util.List;

public interface CourseService {
    Course create(Course course);
    List<Course> getAllCourses();
    Course findById(Long id);
    Course deleteById(Long id);
}
