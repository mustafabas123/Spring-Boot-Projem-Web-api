package OkulProjesi.Mustafa.Service.imp;

import OkulProjesi.Mustafa.Dto.TeacherDto;
import OkulProjesi.Mustafa.Entity.Teacher;
import OkulProjesi.Mustafa.Repository.TeacherRepository;
import OkulProjesi.Mustafa.Service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceimp implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    public TeacherServiceimp(TeacherRepository teacherRepository, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher=modelMapper.map(teacherDto,Teacher.class);
        return modelMapper.map(teacherRepository.save(teacher),TeacherDto.class);
    }

    @Override
    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers=teacherRepository.findAll();
        List<TeacherDto> teacherDtos=teachers.stream().map(teacher -> modelMapper.map(teacher,TeacherDto.class)).collect(Collectors.toList());
        return teacherDtos;
    }

    @Override
    public TeacherDto getTeacher(Integer id) {
        Optional<Teacher> teacher=teacherRepository.findById(id);
        if(teacher.isPresent()){
            return modelMapper.map(teacher.get(),TeacherDto.class);
        }
        throw new IllegalStateException("Yapmak istediğinz işlem gerçekleşmedi");
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
    public TeacherDto updateTeacher(Integer id, TeacherDto teacher) {
        Optional<Teacher> resultTeacher=teacherRepository.findById(id);
        if(resultTeacher.isPresent()){
            resultTeacher.get().setName(teacher.getName());
            resultTeacher.get().setSurname(teacher.getSurname());
            resultTeacher.get().setSection(teacher.getSection());
            resultTeacher.get().setAge(teacher.getAge());
            return modelMapper.map(teacherRepository.save(resultTeacher.get()),TeacherDto.class);
        }
        throw new IllegalStateException("Yapmak istediğinz işlem gerçekleşmedi");
    }

    @Override
    public Page<Teacher> pagination(int currentPage, int pageSize) {
        Pageable pageable= PageRequest.of(currentPage,pageSize);
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Page<Teacher> pagination(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }
}
