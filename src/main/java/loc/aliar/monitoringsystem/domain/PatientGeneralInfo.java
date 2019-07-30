package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PatientGeneralInfo extends AbstractModel {
    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(length = 50)
    private String middleName;

    @Column(length = 255)
    private String photo;

    @Column(nullable = false)
    private Boolean isWork;

    @Column(nullable = false)
    private Boolean isMale;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(length = 12)
    private String phone;

    @Column(length = 130)
    private String email;

    @ManyToOne
    private Education education;
}
