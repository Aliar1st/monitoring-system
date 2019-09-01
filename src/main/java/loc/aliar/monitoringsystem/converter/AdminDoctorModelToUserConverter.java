package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.AdminDoctorModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminDoctorModelToUserConverter implements Converter<AdminDoctorModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(AdminDoctorModel source) {
        return User.builder()
                .id(source.getId())
                .username(source.getUsername())
                .password(passwordEncoder.encode(source.getPassword()))
                .role(Role.Roles.DOCTOR.getRole())
                .build();
    }
}
