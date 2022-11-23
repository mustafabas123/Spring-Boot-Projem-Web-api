package OkulProjesi.Mustafa.Service;

import OkulProjesi.Mustafa.Entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getStudent();

    Boolean deleteStudent(Integer id);
    Student updateStudent(Integer id,Student student);
}
