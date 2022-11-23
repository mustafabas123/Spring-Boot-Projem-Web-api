package OkulProjesi.Mustafa.Entity;


import lombok.*;

import javax.persistence.*;

@Entity(name = "Teacher")
@Table
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Name;
    private String Surname;
    private String Section;
    private Integer Age;
}
