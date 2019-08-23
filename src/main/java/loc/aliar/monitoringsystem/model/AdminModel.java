package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.repository.DepartmentRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import loc.aliar.monitoringsystem.validation.annotation.NewUserPassword;
import loc.aliar.monitoringsystem.validation.annotation.NotNullIfRole;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NewUserPassword
public class AdminModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 50)
    @Unique(value = UserRepository.class,
            fieldName = "username")
    private String username;

    @NotEmpty
    @Size(min = 4, max = 50)
    private String password;

    @NotNullIfRole(Role.Roles.SUPER_ADMIN)
    @Exists(DepartmentRepository.class)
    private Integer departmentId;
}
