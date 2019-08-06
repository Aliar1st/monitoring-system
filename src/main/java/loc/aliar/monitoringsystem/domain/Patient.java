package loc.aliar.monitoringsystem.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Patient extends AbstractModel {
    @OneToOne(optional = false)
    private PatientGeneralInfo patientGeneralInfo;

    @OneToOne
    private CardioMedicalInfo cardioMedicalInfo;

    @OneToOne(optional = false)
    private User user;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "patient")
    private List<Reading> readings;

    @Builder
    public Patient(Long id, PatientGeneralInfo patientGeneralInfo, CardioMedicalInfo cardioMedicalInfo, User user) {
        super(id);
        this.patientGeneralInfo = patientGeneralInfo;
        this.cardioMedicalInfo = cardioMedicalInfo;
        this.user = user;
    }
}
