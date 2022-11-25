package OkulProjesi.Mustafa.Controller;


import OkulProjesi.Mustafa.Dto.TeacherDto;
import OkulProjesi.Mustafa.Entity.Teacher;
import OkulProjesi.Mustafa.Service.imp.TeacherServiceimp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacher){
        TeacherDto resultTeacher=teacherServiceimp.createTeacher(teacher);
        return ResponseEntity.ok(resultTeacher);
    }
    @GetMapping("/getAll")
    public ResponseEntity <List<TeacherDto>> getTeachers(){
        List<TeacherDto> teachers=teacherServiceimp.getTeachers();
        return ResponseEntity.ok(teachers);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deleteTeacher(@PathVariable("Id") Integer id){
        Boolean status=teacherServiceimp.deleteTeacher(id);
        return ResponseEntity.ok(status);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("id") Integer id,@RequestBody TeacherDto teacher){
        TeacherDto resultTeacher=teacherServiceimp.updateTeacher(id,teacher);
        return ResponseEntity.ok(resultTeacher);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable("id") Integer id){
        TeacherDto teacher=teacherServiceimp.getTeacher(id);
        return ResponseEntity.ok(teacher);
    }
    @GetMapping("/pagination")
    public ResponseEntity<Page<Teacher>> pagination(@RequestParam int currentPage,@RequestParam int pageSize){
        return ResponseEntity.ok(teacherServiceimp.pagination(currentPage,pageSize));
    }
    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<Teacher>>pagination(Pageable pageable){
        return ResponseEntity.ok(teacherServiceimp.pagination(pageable));
    }
}
