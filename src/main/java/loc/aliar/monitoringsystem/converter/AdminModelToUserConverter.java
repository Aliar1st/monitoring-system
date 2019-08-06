package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.AdminModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminModelToUserConverter implements Converter<AdminModel, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User convert(AdminModel source) {
        return User.builder()
                .id(source.getId())
                .username(source.getUsername())
                .password(passwordEncoder.encode(source.getPassword()))
                .role(Role.Roles.ADMIN.getRole())
                .build();
    }
}
