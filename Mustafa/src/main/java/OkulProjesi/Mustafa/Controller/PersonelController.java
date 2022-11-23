package OkulProjesi.Mustafa.Controller;

import OkulProjesi.Mustafa.Entity.Personel;
import OkulProjesi.Mustafa.Service.imp.PersonelServiceimp;
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
    public ResponseEntity<Personel> createPersonel(@RequestBody Personel personel){
        Personel resultPersonel=personelServiceimp.createPersonel(personel);
        return ResponseEntity.ok(resultPersonel);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Personel>> getPersonel(){
        List<Personel> personels=personelServiceimp.getUser();
        return ResponseEntity.ok(personels);
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> deletePersonel(@PathVariable("Id") Integer id){
        Boolean status=personelServiceimp.deletePersonel(id);
        return ResponseEntity.ok(status);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Personel> updatePersonel(@PathVariable("id") Integer id,@RequestBody Personel personel){
        Personel resultPersonel=personelServiceimp.updatePersonel(id,personel);
        return ResponseEntity.ok(resultPersonel);
    }
}
