package OkulProjesi.Mustafa.Service;

import OkulProjesi.Mustafa.Dto.PersonelDto;
import OkulProjesi.Mustafa.Entity.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonelService {
    PersonelDto createPersonel(PersonelDto personel);
    List<PersonelDto> getUsers();

    Boolean deletePersonel(Integer id);
    PersonelDto updatePersonel(Integer id,PersonelDto personel);
    PersonelDto getUser(Integer id);
    Page<Personel> pagination(int currentPage,int pageSize);
    Page<Personel> pagination(Pageable pageable);
}
