package OkulProjesi.Mustafa.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Integer Number;
    private String Name;
    private String Surname;
    private Integer Grade;
    private String Branch;
}
