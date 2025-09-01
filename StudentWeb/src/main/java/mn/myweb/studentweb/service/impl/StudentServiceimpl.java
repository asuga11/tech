package mn.myweb.studentweb.service.impl;

import mn.myweb.studentweb.model.Student;
import mn.myweb.studentweb.repository.StudentRepository;
import mn.myweb.studentweb.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setLastName(student.getLastName());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setAge(student.getAge());
        existingStudent.setGender(student.getGender());
        return studentRepository.save(existingStudent);
    }

    @Override
    public String deleteStudent(Long id) {
        return "";
    }

    @Override
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "oyutnii medeelel ustlee..." ;

    }
}
