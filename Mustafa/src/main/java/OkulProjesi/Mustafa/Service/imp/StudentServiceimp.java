package OkulProjesi.Mustafa.Service.imp;

import OkulProjesi.Mustafa.Entity.Student;
import OkulProjesi.Mustafa.Repository.StudentRepository;
import OkulProjesi.Mustafa.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimp implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceimp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Optional<Student> resultStudent=studentRepository.findById(id);
        if(resultStudent.isPresent()){
            resultStudent.get().setName(student.getName());
            resultStudent.get().setSurname(student.getSurname());
            resultStudent.get().setNumber(student.getNumber());
            resultStudent.get().setBranch(student.getBranch());
            resultStudent.get().setNumber(student.getNumber());
            return studentRepository.save(resultStudent.get());
        }
        return null;
    }
}
