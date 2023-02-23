package gr.hua.reference.letters.spring.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher extends User {

    @Getter
    @Setter
    private List<String> courses;

    @Getter
    @Setter
    private List<Certificate> certificates;

}
