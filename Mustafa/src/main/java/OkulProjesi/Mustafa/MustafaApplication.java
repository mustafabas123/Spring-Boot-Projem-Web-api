package OkulProjesi.Mustafa;

import OkulProjesi.Mustafa.Entity.Personel;
import OkulProjesi.Mustafa.Entity.Student;
import OkulProjesi.Mustafa.Entity.Teacher;
import OkulProjesi.Mustafa.Repository.PersonelRepository;
import OkulProjesi.Mustafa.Repository.StudentRepository;
import OkulProjesi.Mustafa.Repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class  MustafaApplication implements CommandLineRunner {
	private final PersonelRepository personelRepository;
	private final StudentRepository studentRepository;
	private final TeacherRepository teacherRepository;

	public MustafaApplication(PersonelRepository personelRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
		this.personelRepository = personelRepository;
		this.studentRepository = studentRepository;
		this.teacherRepository = teacherRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MustafaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Personel personel1=Personel.builder().Name("Ali").Surname("Paşalı").age(27).Salary(4800).build();
		Personel personel2=Personel.builder().Name("Muhammet").Surname("Göker").age(26).Salary(4800).build();
		Personel personel3=Personel.builder().Name("Özge").Surname("Alıcı").age(25).Salary(4800).build();
		Personel personel4=Personel.builder().Name("Sevil").Surname("Atak").age(24).Salary(5000).build();
		Personel personel5=Personel.builder().Name("Nihat").Surname("Baş").age(34).Salary(5800).build();
		Personel personel6=Personel.builder().Name("Vedat").Surname("Bayram").age(32).Salary(5800).build();
		Personel personel7=Personel.builder().Name("Öznür").Surname("Göker").age(26).Salary(4800).build();
		Personel personel8=Personel.builder().Name("Semanur").Surname("Alıcı").age(25).Salary(4800).build();
		Personel personel9=Personel.builder().Name("Hacer").Surname("Akar").age(44).Salary(5000).build();
		Personel personel10=Personel.builder().Name("İlker").Surname("Aydın").age(34).Salary(5800).build();
		Personel personel11=Personel.builder().Name("Onur").Surname("Varan").age(28).Salary(4800).build();
		Personel personel12=Personel.builder().Name("").Surname("Göker").age(26).Salary(4800).build();
		Personel personel13=Personel.builder().Name("Özge").Surname("Alıcı").age(25).Salary(4800).build();
		Personel personel14=Personel.builder().Name("Sevil").Surname("Atak").age(24).Salary(5000).build();
		Personel personel15=Personel.builder().Name("Nihat").Surname("Baş").age(34).Salary(5800).build();
		personelRepository.saveAll(Arrays.asList(personel1,personel2,personel3,personel4,personel5,personel6,personel7,personel8
		,personel9,personel10,personel11,personel12,personel13,personel14,personel15));

		Student student1=Student.builder().Number(10).Name("Recep").Surname("İvedik").Grade(9).Branch("A").build();
		Student student2=Student.builder().Number(13).Name("Mustafa").Surname("Akif").Grade(9).Branch("A").build();
		Student student3=Student.builder().Number(15).Name("Onur").Surname("Aykaç").Grade(9).Branch("A").build();
		Student student4=Student.builder().Number(26).Name("Arif").Surname("Alkan").Grade(9).Branch("A").build();
		Student student5=Student.builder().Number(56).Name("Vedat").Surname("Kapı").Grade(9).Branch("A").build();
		Student student6=Student.builder().Number(70).Name("Recep").Surname("İvedik").Grade(9).Branch("A").build();
		Student student7=Student.builder().Number(67).Name("Mustafa").Surname("Akif").Grade(9).Branch("A").build();
		Student student8=Student.builder().Number(78).Name("Onur").Surname("Aykaç").Grade(9).Branch("A").build();
		Student student9=Student.builder().Number(123).Name("Arif").Surname("Alkan").Grade(9).Branch("A").build();
		Student student10=Student.builder().Number(67).Name("Vedat").Surname("Kapı").Grade(9).Branch("A").build();
		Student student11=Student.builder().Number(45).Name("Recep").Surname("İvedik").Grade(9).Branch("A").build();
		Student student12=Student.builder().Number(32).Name("Mustafa").Surname("Akif").Grade(9).Branch("A").build();
		Student student13=Student.builder().Number(21).Name("Onur").Surname("Aykaç").Grade(9).Branch("A").build();
		Student student14=Student.builder().Number(12).Name("Arif").Surname("Alkan").Grade(9).Branch("A").build();
		Student student15=Student.builder().Number(86).Name("Vedat").Surname("Kapı").Grade(9).Branch("A").build();
		Student student16=Student.builder().Number(10).Name("Recep").Surname("İvedik").Grade(9).Branch("A").build();
		Student student17=Student.builder().Number(13).Name("Mustafa").Surname("Akif").Grade(9).Branch("A").build();
		Student student18=Student.builder().Number(15).Name("Onur").Surname("Aykaç").Grade(9).Branch("A").build();
		Student student19=Student.builder().Number(26).Name("Arif").Surname("Alkan").Grade(9).Branch("A").build();
		Student student20=Student.builder().Number(56).Name("Vedat").Surname("Kapı").Grade(9).Branch("A").build();

		studentRepository.saveAll(Arrays.asList(student1,student2,student3,student4,student5,student6,student7,student8,student9
		,student9,student10,student11,student12,student13,student14,student15,student16,student17,student18,student19,student20));

		Teacher teacher1=Teacher.builder().Name("Haluk").Surname("Bayram").Section("Matamatik").Age(41).build();
		Teacher teacher2=Teacher.builder().Name("Nihat").Surname("Kahveci").Section("Fen bilgisi").Age(35).build();
		Teacher teacher3=Teacher.builder().Name("Semih").Surname("Öztürk").Section("Resim").Age(25).build();
		Teacher teacher4=Teacher.builder().Name("Özgür").Surname("Uygar").Section("Müzik").Age(45).build();
		Teacher teacher5=Teacher.builder().Name("Sevda").Surname("Gül").Section("Dil anlatım").Age(24).build();
		Teacher teacher6=Teacher.builder().Name("Haluk").Surname("Bayram").Section("Matamatik").Age(41).build();
		Teacher teacher7=Teacher.builder().Name("Nihat").Surname("Kahveci").Section("Fen bilgisi").Age(35).build();
		Teacher teacher8=Teacher.builder().Name("Semih").Surname("Öztürk").Section("Resim").Age(25).build();
		Teacher teacher9=Teacher.builder().Name("Özgür").Surname("Uygar").Section("Müzik").Age(45).build();
		Teacher teacher10=Teacher.builder().Name("Sevda").Surname("Gül").Section("Dil anlatım").Age(24).build();
		Teacher teacher11=Teacher.builder().Name("Haluk").Surname("Bayram").Section("Matamatik").Age(41).build();
		Teacher teacher12=Teacher.builder().Name("Nihat").Surname("Kahveci").Section("Fen bilgisi").Age(35).build();
		Teacher teacher13=Teacher.builder().Name("Semih").Surname("Öztürk").Section("Resim").Age(25).build();
		Teacher teacher14=Teacher.builder().Name("Özgür").Surname("Uygar").Section("Müzik").Age(45).build();
		Teacher teacher15=Teacher.builder().Name("Sevda").Surname("Gül").Section("Dil anlatım").Age(24).build();
		Teacher teacher16=Teacher.builder().Name("Haluk").Surname("Bayram").Section("Matamatik").Age(41).build();
		Teacher teacher17=Teacher.builder().Name("Nihat").Surname("Kahveci").Section("Fen bilgisi").Age(35).build();
		Teacher teacher18=Teacher.builder().Name("Semih").Surname("Öztürk").Section("Resim").Age(25).build();
		Teacher teacher19=Teacher.builder().Name("Özgür").Surname("Uygar").Section("Müzik").Age(45).build();
		Teacher teacher20=Teacher.builder().Name("Sevda").Surname("Gül").Section("Dil anlatım").Age(24).build();
		Teacher teacher21=Teacher.builder().Name("Haluk").Surname("Bayram").Section("Matamatik").Age(41).build();
		Teacher teacher22=Teacher.builder().Name("Nihat").Surname("Kahveci").Section("Fen bilgisi").Age(35).build();
		Teacher teacher23=Teacher.builder().Name("Semih").Surname("Öztürk").Section("Resim").Age(25).build();
		Teacher teacher24=Teacher.builder().Name("Özgür").Surname("Uygar").Section("Müzik").Age(45).build();
		Teacher teacher25=Teacher.builder().Name("Sevda").Surname("Gül").Section("Dil anlatım").Age(24).build();

		teacherRepository.saveAll(Arrays.asList(teacher1,teacher2,teacher3,teacher4,teacher5,teacher6,teacher7,teacher8,teacher9
		,teacher10,teacher11,teacher12,teacher13,teacher14,teacher15,teacher16,teacher17,teacher18,teacher19,teacher20,teacher21
		,teacher22,teacher23,teacher24,teacher25));
	}
}
