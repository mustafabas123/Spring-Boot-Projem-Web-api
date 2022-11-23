package OkulProjesi.Mustafa.Service.imp;

import OkulProjesi.Mustafa.Entity.Teacher;
import OkulProjesi.Mustafa.Repository.TeacherRepository;
import OkulProjesi.Mustafa.Service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceimp implements TeacherService {
    public final TeacherRepository teacherRepository;

    public TeacherServiceimp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Boolean deleteTeacher(Integer id) {
        Optional<Teacher> teacher=teacherRepository.findById(id);
        if(teacher.isPresent()){
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Teacher updateTeacher(Integer id, Teacher teacher) {
        Optional<Teacher> resultTeacher=teacherRepository.findById(id);
        if(resultTeacher.isPresent()){
            resultTeacher.get().setName(teacher.getName());
            resultTeacher.get().setSurname(teacher.getSurname());
            resultTeacher.get().setSection(teacher.getSection());
            resultTeacher.get().setAge(teacher.getAge());
            return teacherRepository.save(resultTeacher.get());
        }
        return null;
    }
}
