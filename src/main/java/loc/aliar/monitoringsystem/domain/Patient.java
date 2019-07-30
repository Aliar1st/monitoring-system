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
public class Patient extends AbstractModel {
    @OneToOne(optional = false)
    private PatientGeneralInfo patientGeneralInfo;

    @OneToOne
    private CardioMedicalInfo cardioMedicalInfo;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors;

    @OneToOne(optional = false)
    private User user;

    @OneToMany(mappedBy = "patient")
    private List<Reading> readings;
}
