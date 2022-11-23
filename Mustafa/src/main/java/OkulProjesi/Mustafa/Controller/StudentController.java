package OkulProjesi.Mustafa.Controller;


import OkulProjesi.Mustafa.Entity.Personel;
import OkulProjesi.Mustafa.Entity.Student;
import OkulProjesi.Mustafa.Service.imp.StudentServiceimp;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student resultStudent=studentServiceimp.createStudent(student);
        return ResponseEntity.ok(resultStudent);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> students=studentServiceimp.getStudent();
        return ResponseEntity.ok(students);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("Id") Integer id){
        Boolean status=studentServiceimp.deleteStudent(id);
        return ResponseEntity.ok(status);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id,@RequestBody Student student){
        Student resultStudent=studentServiceimp.updateStudent(id,student);
        return ResponseEntity.ok(resultStudent);
    }
}
