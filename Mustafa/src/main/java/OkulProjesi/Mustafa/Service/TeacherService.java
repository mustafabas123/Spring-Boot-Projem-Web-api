package OkulProjesi.Mustafa.Service;

import OkulProjesi.Mustafa.Entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    List<Teacher> getTeacher();

    Boolean deleteTeacher(Integer id);

    Teacher updateTeacher(Integer id,Teacher teacher);
}
