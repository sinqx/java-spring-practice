package itAcademy.exam7.students.service;

import itAcademy.exam7.students.entity.Student;
import itAcademy.exam7.students.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepository;
    @Autowired
    private CourseService courseService;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<String> getByName(String name) {
        List<Student> students = getAllStudents();
        List<String> studentsByName = null;
        for (Student student : students) {
            String findStudent = student.getFullName();
            Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(findStudent);
            while (matcher.find()) {
                assert false;
                studentsByName.add(findStudent.substring(matcher.start(), matcher.end()));
            }
        }
        return studentsByName;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student deleteById(Long id) {
        Student student = findById(id);
        if (student != null){
            studentRepository.delete(student);
            return student;
        }
        return null;
    }

}
