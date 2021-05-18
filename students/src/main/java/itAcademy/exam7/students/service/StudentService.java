package itAcademy.exam7.students.service;

import itAcademy.exam7.students.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<String> getByName(String name);
    List<Student> getAllStudents();
    Student findById(Long id);
    Student deleteById(Long id);
}
