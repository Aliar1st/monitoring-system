package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.repository.*;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import loc.aliar.monitoringsystem.validation.annotation.NewUserPassword;
import loc.aliar.monitoringsystem.validation.annotation.NotNullIfRole;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.*;

import javax.validation.constraints.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NewUserPassword
public class DoctorModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 50)
    @Unique(value = UserRepository.class,
            fieldName = "username")
    private String username;

    @NotEmpty
    @Size(min = 4, max = 50)
    private String password;


    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    @Size(min = 2, max = 50)
    private String middleName;

    @NotEmpty
    @Email
    @Size(max = 130)
    private String email;

    @Pattern(regexp = "(\\+7|7|8)[0-9]{10}")
    @Size(min = 11, max = 12)
    private String phone;

    @NotNull
    @Exists(SpecializationRepository.class)
    private Long specializationId;

    @NotNull
    @Exists(DegreeRepository.class)
    private Long degreeId;

    @NotNull
    @Exists(PositionRepository.class)
    private Long positionId;

    @NotNullIfRole(Role.Roles.SUPER_ADMIN)
    @Exists(DepartmentRepository.class)
    private Integer departmentId;
}
