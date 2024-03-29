package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Patient extends AbstractModel {
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

    @MapsId
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors;

    @OneToOne(mappedBy = "patient", fetch = FetchType.LAZY)
    private CardioMedicalInfo cardioMedicalInfo;

    @OneToMany(mappedBy = "patient")
    private List<CardioReading> cardioReadings;

    public Patient(Long id) {
        super(id);
    }

    @Builder
    public Patient(Long id, String firstName, String lastName, String middleName, String photo, Boolean isWork,
                   Boolean isMale, LocalDate dateOfBirth, String phone, String email, Education education, User user) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.photo = photo;
        this.isWork = isWork;
        this.isMale = isMale;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.user = user;
    }
}
