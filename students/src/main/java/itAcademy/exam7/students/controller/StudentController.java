package itAcademy.exam7.students.controller;


import itAcademy.exam7.students.entity.Student;
import itAcademy.exam7.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/{listId}")
    public Student getById(@PathVariable Long listId){
        return studentService.findById(listId);
    }

    @GetMapping("/{name}")
    public List<String> getByName(@PathVariable String name){
        return studentService.getByName(name);
    }

    @DeleteMapping("/{listId}")
    public Student deleteById(@PathVariable Long listId){
        return studentService.deleteById(listId);
    }
}
