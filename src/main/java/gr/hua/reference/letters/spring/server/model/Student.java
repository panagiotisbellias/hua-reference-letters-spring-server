package gr.hua.reference.letters.spring.server.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student extends User {

    private String school;
    private String university;
    private String studentID;
    private String gradingFileURL;

}
