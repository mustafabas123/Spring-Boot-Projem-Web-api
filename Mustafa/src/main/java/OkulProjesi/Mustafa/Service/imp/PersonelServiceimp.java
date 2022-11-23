package OkulProjesi.Mustafa.Service.imp;

import OkulProjesi.Mustafa.Entity.Personel;
import OkulProjesi.Mustafa.Repository.PersonelRepository;
import OkulProjesi.Mustafa.Service.PersonelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelServiceimp implements PersonelService {
    private final PersonelRepository personelRepository;

    public PersonelServiceimp(PersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    @Override
    public Personel createPersonel(Personel personel) {
        return personelRepository.save(personel);
    }

    @Override
    public List<Personel> getUser() {
        return personelRepository.findAll();
    }

    @Override
    public Boolean deletePersonel(Integer id) {
        Optional<Personel> personel=personelRepository.findById(id);
        if(personel.isPresent()){
            personelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Personel updatePersonel(Integer id, Personel personel) {
        Optional<Personel> resultPersonel=personelRepository.findById(id);
        if(resultPersonel.isPresent()){
            resultPersonel.get().setName(personel.getName());
            resultPersonel.get().setSurname(personel.getSurname());
            resultPersonel.get().setAge(personel.getAge());
            resultPersonel.get().setSalary(personel.getSalary());
            return personelRepository.save(resultPersonel.get());
        }
        return null;
    }
}
