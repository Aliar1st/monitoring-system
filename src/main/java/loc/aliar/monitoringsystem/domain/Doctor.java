package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Specialization specialization;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Degree degree;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Position position;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @ManyToOne(optional = false)
    private Department department;

    @ManyToMany
    private List<Patient> patients;

    @Builder
    public Doctor(
            Long id, String firstName, String lastName, String middleName, String phone, String email,
            Specialization specialization, Degree degree, Position position, User user, Department department) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.specialization = specialization;
        this.degree = degree;
        this.position = position;
        this.user = user;
        this.department = department;
    }
}
