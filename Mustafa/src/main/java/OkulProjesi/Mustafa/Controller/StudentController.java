package OkulProjesi.Mustafa.Controller;


import OkulProjesi.Mustafa.Dto.StudentDto;
import OkulProjesi.Mustafa.Entity.Personel;
import OkulProjesi.Mustafa.Entity.Student;
import OkulProjesi.Mustafa.Service.imp.StudentServiceimp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Student")
public class StudentController {
    private final StudentServiceimp studentServiceimp;

    public StudentController(StudentServiceimp studentServiceimp) {
        this.studentServiceimp = studentServiceimp;
    }
    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student){
        StudentDto resultStudent=studentServiceimp.createStudent(student);
        return ResponseEntity.ok(resultStudent);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getStudents(){
        List<StudentDto> students=studentServiceimp.getStudents();
        return ResponseEntity.ok(students);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("Id") Integer id){
        Boolean status=studentServiceimp.deleteStudent(id);
        return ResponseEntity.ok(status);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Integer id,@RequestBody StudentDto student){
        StudentDto resultStudent=studentServiceimp.updateStudent(id,student);
        return ResponseEntity.ok(resultStudent);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<StudentDto> getUser(@PathVariable("id") Integer id){
        StudentDto student=studentServiceimp.getStudent(id);
        return ResponseEntity.ok(student);
    }
    @GetMapping("/pagination")
    public ResponseEntity<Page<Student>> pagination(@RequestParam int currentPage,@RequestParam int pageSize){
        return ResponseEntity.ok(studentServiceimp.pagination(currentPage,pageSize));
    }
    @GetMapping("pagination/v1")
    public ResponseEntity<Page<Student>>pagination(Pageable pageable){
        return  ResponseEntity.ok(studentServiceimp.pagination(pageable));
    }
}
