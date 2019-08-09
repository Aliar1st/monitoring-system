package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.PatientModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class PatientModelToUserConverter implements Converter<PatientModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(PatientModel source) {
        User user = User.builder()
                .id(source.getId())
                .username(source.getUsername())
                .role(Role.Roles.PATIENT.getRole())
                .build();

        if (StringUtils.hasText(source.getPassword())) {
            user.setPassword(passwordEncoder.encode(source.getPassword()));
        }

        return user;
    }
}
