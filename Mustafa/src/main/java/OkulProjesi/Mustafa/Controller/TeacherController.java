package OkulProjesi.Mustafa.Controller;


import OkulProjesi.Mustafa.Entity.Teacher;
import OkulProjesi.Mustafa.Service.imp.TeacherServiceimp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Teacher")
public class TeacherController {
    private final TeacherServiceimp teacherServiceimp;

    public TeacherController(TeacherServiceimp teacherServiceimp) {
        this.teacherServiceimp = teacherServiceimp;
    }
    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        Teacher resultTeacher=teacherServiceimp.createTeacher(teacher);
        return ResponseEntity.ok(resultTeacher);
    }
    @GetMapping("/getAll")
    public ResponseEntity <List<Teacher>> getTeacher(){
        List<Teacher> teachers=teacherServiceimp.getTeacher();
        return ResponseEntity.ok(teachers);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deleteTeacher(@PathVariable("Id") Integer id){
        Boolean status=teacherServiceimp.deleteTeacher(id);
        return ResponseEntity.ok(status);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Integer id,@RequestBody Teacher teacher){
        Teacher resultTeacher=teacherServiceimp.updateTeacher(id,teacher);
        return ResponseEntity.ok(resultTeacher);
    }
}
