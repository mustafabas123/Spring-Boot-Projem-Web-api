package OkulProjesi.Mustafa.Service;

import OkulProjesi.Mustafa.Dto.StudentDto;
import OkulProjesi.Mustafa.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto student);
    List<StudentDto> getStudents();
    StudentDto getStudent(Integer id);

    Boolean deleteStudent(Integer id);
    StudentDto updateStudent(Integer id,StudentDto student);

    Page<Student>pagination(int currrentPage,int pageSize);
    Page<Student>pagination(Pageable pageable);
}
