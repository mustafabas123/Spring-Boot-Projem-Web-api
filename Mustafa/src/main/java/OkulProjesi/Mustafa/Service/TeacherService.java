package OkulProjesi.Mustafa.Service;

import OkulProjesi.Mustafa.Dto.TeacherDto;
import OkulProjesi.Mustafa.Entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacher);
    List<TeacherDto> getTeachers();

    TeacherDto getTeacher(Integer id);

    Boolean deleteTeacher(Integer id);

    TeacherDto updateTeacher(Integer id,TeacherDto teacher);
    Page<Teacher> pagination(int currentPage,int pageSize);
    Page<Teacher> pagination(Pageable pageable);
}
