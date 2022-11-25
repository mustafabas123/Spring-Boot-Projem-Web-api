package OkulProjesi.Mustafa.Controller;

import OkulProjesi.Mustafa.Dto.PersonelDto;
import OkulProjesi.Mustafa.Entity.Personel;
import OkulProjesi.Mustafa.Service.imp.PersonelServiceimp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Personel")
public class PersonelController {

    private final PersonelServiceimp personelServiceimp;

    public PersonelController(PersonelServiceimp personelServiceimp) {
        this.personelServiceimp = personelServiceimp;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonelDto> createPersonel(@RequestBody PersonelDto personel){
        PersonelDto resultPersonel=personelServiceimp.createPersonel(personel);
        return ResponseEntity.ok(resultPersonel);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<PersonelDto>> getPersonel(){
        List<PersonelDto> personels=personelServiceimp.getUsers();
        return ResponseEntity.ok(personels);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deletePersonel(@PathVariable("Id") Integer id){
        Boolean status=personelServiceimp.deletePersonel(id);
        return ResponseEntity.ok(status);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonelDto> updatePersonel(@PathVariable("id") Integer id,@RequestBody PersonelDto personel){
        PersonelDto resultPersonel=personelServiceimp.updatePersonel(id,personel);
        return ResponseEntity.ok(resultPersonel);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<PersonelDto> getUser(@PathVariable("id") Integer id){
        PersonelDto personel=personelServiceimp.getUser(id);
        return ResponseEntity.ok(personel);
    }
    @GetMapping("/pagination")
    public ResponseEntity<Page<Personel>> pagination(@RequestParam int currentPage,@RequestParam int pageSize){
        return ResponseEntity.ok(personelServiceimp.pagination(currentPage,pageSize));
    }
    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<Personel>> pagination(Pageable pageable){
        return ResponseEntity.ok(personelServiceimp.pagination(pageable));
    }
}
