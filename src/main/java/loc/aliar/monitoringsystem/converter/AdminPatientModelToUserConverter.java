package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.AdminPatientModel;
import loc.aliar.monitoringsystem.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminPatientModelToUserConverter implements Converter<AdminPatientModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(AdminPatientModel source) {
        return User.builder()
                .id(source.getId())
                .username(source.getUsername())
                .password(ObjectUtils.nullSafe(source.getPassword(), passwordEncoder::encode))
                .role(Role.Roles.PATIENT.getRole())
                .build();
    }
}
