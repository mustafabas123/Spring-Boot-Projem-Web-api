package OkulProjesi.Mustafa.Repository;

import OkulProjesi.Mustafa.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
