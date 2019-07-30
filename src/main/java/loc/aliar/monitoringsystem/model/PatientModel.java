package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.EducationRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel implements IdAble {
    private Long id;

    @NotEmpty
    @Length(min = 4, max = 50)
    @Unique(value = UserRepository.class,
            fieldName = "username")
    private String username;

    @NotEmpty
    @Length(min = 4, max = 50)
    private String password;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    @Size(min = 2, max = 50)
    private String middleName;

    private String photoUrl;

    private MultipartFile photo;

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

    public String fullName() {
        return getLastName() + " " + getFirstName();
    }
}
