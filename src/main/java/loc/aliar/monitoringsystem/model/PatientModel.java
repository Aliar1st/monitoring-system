package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.config.Constants;
import loc.aliar.monitoringsystem.repository.EducationRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    @Size(min = 2, max = 50)
    private String middleName;

    private String photoUrl;

    @NotNull
    private Boolean isWork;

    @NotNull
    private Boolean isMale;

    @NotNull
    private LocalDate dateOfBirth;

    @Size(min = 11, max = 12)
    private String phone;

    @Email
    @Size(max = 130)
    private String email;

    @Exists(EducationRepository.class)
    private Long educationId;

    public String getFullName() {
        return String.format(Constants.FULL_NAME_FORMAT, getFirstName(), getLastName());
    }
}
