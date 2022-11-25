package OkulProjesi.Mustafa.Service.imp;

import OkulProjesi.Mustafa.Dto.StudentDto;
import OkulProjesi.Mustafa.Entity.Student;
import OkulProjesi.Mustafa.Repository.StudentRepository;
import OkulProjesi.Mustafa.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceimp implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceimp(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student=modelMapper.map(studentDto,Student.class);
        return modelMapper.map(studentRepository.save(student),StudentDto.class);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> students=studentRepository.findAll();
        List<StudentDto> studentDtos=students.stream().
                map(student -> modelMapper.map(student,StudentDto.class)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public StudentDto getStudent(Integer id) {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent()){
            return modelMapper.map(student.get(),StudentDto.class);
        }
        throw new IllegalStateException("Yapmak istediğinz işlem gerçekleşmedi");
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
    public StudentDto updateStudent(Integer id, StudentDto student) {
        Optional<Student> resultStudent=studentRepository.findById(id);
        if(resultStudent.isPresent()){
            resultStudent.get().setName(student.getName());
            resultStudent.get().setSurname(student.getSurname());
            resultStudent.get().setNumber(student.getNumber());
            resultStudent.get().setBranch(student.getBranch());
            resultStudent.get().setNumber(student.getNumber());
            return modelMapper.map(studentRepository.save(resultStudent.get()),StudentDto.class);
        }
        throw new IllegalStateException("Yapmak istediğinz işlem gerçekleşmedi");
    }

    @Override
    public Page<Student> pagination(int currrentPage, int pageSize) {
        Pageable pageable= PageRequest.of(currrentPage,pageSize);
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> pagination(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}
