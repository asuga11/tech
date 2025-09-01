package mn.myweb.studentweb.service;

import mn.myweb.studentweb.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    String deleteStudent(Long id);

    String deleteStudentById(Long id);
}
