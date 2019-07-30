package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Doctor extends AbstractModel {
    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(length = 50)
    private String middleName;

    @Column(length = 12)
    private String phone;

    @Column(length = 130)
    private String email;

//    @ManyToOne(optional = false)
    @ManyToOne
    private Specialization specialization;

//    @ManyToOne(optional = false)
    @ManyToOne
    private Degree degree;

//    @ManyToOne(optional = false)
    @ManyToOne
    private Position position;

    @OneToOne(optional = false)
    private User user;

//    @ManyToOne(optional = false)
    @ManyToOne
    private Department department;

    @ManyToMany
    private List<Patient> patients;
}
