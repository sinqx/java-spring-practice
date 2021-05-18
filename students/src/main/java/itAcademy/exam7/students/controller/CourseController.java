package itAcademy.exam7.students.controller;

import itAcademy.exam7.students.entity.Course;
import itAcademy.exam7.students.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course create(@RequestBody Course course){
        return courseService.create(course);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{userId}")
    public Course getById(@PathVariable Long userId){
        return courseService.findById(userId);
    }
}
