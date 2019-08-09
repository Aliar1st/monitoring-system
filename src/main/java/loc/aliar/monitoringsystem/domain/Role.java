package loc.aliar.monitoringsystem.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {
    public static final Map<Integer, Roles> ID_ROLES = new HashMap<>();

    @Getter
    public enum Roles {
        SUPER_ADMIN(1),
        ADMIN(2),
        DOCTOR(3),
        PATIENT(4);

        private final int id;
        private final Role role;

        Roles(int id) {
            this.id = id;
            this.role = new Role(id);
            ID_ROLES.put(id, this);
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String authority;

    public Role(Integer id) {
        this.id = id;
    }
}
