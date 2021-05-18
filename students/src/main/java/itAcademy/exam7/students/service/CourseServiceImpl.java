package itAcademy.exam7.students.service;

import itAcademy.exam7.students.entity.Course;
import itAcademy.exam7.students.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepository;

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course deleteById(Long id) {
        Course course = findById(id);
        if (course != null){
            courseRepository.delete(course);
            return course;
        }
        return null;
    }

}
