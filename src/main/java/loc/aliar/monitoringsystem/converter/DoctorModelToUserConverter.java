package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.DoctorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorModelToUserConverter implements Converter<DoctorModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(DoctorModel source) {
        return User.builder()
                .username(source.getUsername())
                .password(passwordEncoder.encode(source.getPassword()))
                .role(Role.Roles.DOCTOR.getRole())
                .build();
    }
}
