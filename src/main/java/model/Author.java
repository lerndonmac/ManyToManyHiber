package model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String otchestvo;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                '}';
    }

}
