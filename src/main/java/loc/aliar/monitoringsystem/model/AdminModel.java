package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.DepartmentRepository;
import loc.aliar.monitoringsystem.repository.UserRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import loc.aliar.monitoringsystem.validation.annotation.NewUserPassword;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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


    @NotNull
    @Exists(DepartmentRepository.class)
    private Integer departmentId;
}
