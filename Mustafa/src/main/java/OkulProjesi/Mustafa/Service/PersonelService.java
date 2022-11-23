package OkulProjesi.Mustafa.Service;

import OkulProjesi.Mustafa.Entity.Personel;

import java.util.List;

public interface PersonelService {
    Personel createPersonel(Personel personel);
    List<Personel> getUser();

    Boolean deletePersonel(Integer id);
    Personel updatePersonel(Integer id,Personel personel);
}
