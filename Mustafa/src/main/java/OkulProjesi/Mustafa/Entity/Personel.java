package OkulProjesi.Mustafa.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Personel")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Name;
    private String Surname;
    private Integer age;
    private Integer Salary;
}
