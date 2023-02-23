package gr.hua.reference.letters.spring.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request {

    @Id
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Teacher teacher;

    @Getter
    @Setter
    private Student student;

    @Getter
    @Setter
    private String recipientName;

    @Getter
    @Setter
    private String recipientEmailAddress;

}
