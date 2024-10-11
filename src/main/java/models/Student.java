package models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@Table(name = "students")
@ToString
@NamedQueries {

    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")

}

public class Student {

    @Column (unique = true);
    private String cif;
    @Column(nullable = false)
    @Length(min = 3, max = 60)
    private String firstName;
    @Column(nullable = false)
    @Length(min = 3, max = 60)
    private String lastName;
    @Column (unique = true)
    private String email;










}
