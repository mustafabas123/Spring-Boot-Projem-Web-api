package OkulProjesi.Mustafa.Service.imp;

import OkulProjesi.Mustafa.Dto.PersonelDto;
import OkulProjesi.Mustafa.Entity.Personel;
import OkulProjesi.Mustafa.Repository.PersonelRepository;
import OkulProjesi.Mustafa.Service.PersonelService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonelServiceimp implements PersonelService {
    private final PersonelRepository personelRepository;
    private final ModelMapper modelMapper;

    public PersonelServiceimp(PersonelRepository personelRepository, ModelMapper modelMapper) {
        this.personelRepository = personelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonelDto createPersonel(PersonelDto personelDto) {
        Personel personel=modelMapper.map(personelDto,Personel.class);
        return modelMapper.map(personelRepository.save(personel),PersonelDto.class);
    }

    @Override
    public List<PersonelDto> getUsers() {
        List<Personel>personels=personelRepository.findAll();
        List<PersonelDto> personelDtos=personels.stream().map(personel -> modelMapper.map(personel,PersonelDto.class)).collect(Collectors.toList());
        return personelDtos;
    }

    @Override
    public Boolean deletePersonel(Integer id) {
        Optional<Personel> personel=personelRepository.findById(id);
        if(personel.isPresent()){
            personelRepository.deleteById(id);
            return true;
        }
        throw new IllegalStateException("Yapmak istediğinz işlem gerçekleşmedi");
    }

    @Override
    public PersonelDto updatePersonel(Integer id, PersonelDto personel) {
        Optional<Personel> resultPersonel=personelRepository.findById(id);
        if(resultPersonel.isPresent()){
            resultPersonel.get().setName(personel.getName());
            resultPersonel.get().setSurname(personel.getSurname());
            resultPersonel.get().setAge(personel.getAge());
            resultPersonel.get().setSalary(personel.getSalary());
            return modelMapper.map(personelRepository.save(resultPersonel.get()),PersonelDto.class);
        }
        throw new IllegalStateException("Yapmak istediğinz işlem gerçekleşmedi");
    }

    @Override
    public PersonelDto getUser(Integer id) {
        Optional<Personel> personel=personelRepository.findById(id);
        if(personel.isPresent()){
            return modelMapper.map(personel.get(),PersonelDto.class);
        }
        throw new IllegalStateException("Yapmak istediğinz işlem gerçekleşmedi");
    }
    @Override
    public Page<Personel> pagination(int currentPage, int pageSize) {
        Pageable pageable= PageRequest.of(currentPage,pageSize);
        return personelRepository.findAll(pageable);
    }

    @Override
    public Page<Personel> pagination(Pageable pageable) {
        return personelRepository.findAll(pageable);
    }
}
