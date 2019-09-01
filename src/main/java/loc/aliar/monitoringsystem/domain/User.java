package loc.aliar.monitoringsystem.domain;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usr")
@NamedEntityGraph(name = User.NEGW_ROLE,
        attributeNodes = @NamedAttributeNode("role"))
public class User implements UserDetails {
    public static final String NEGW_ROLE = "User.role";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @ManyToOne(optional = false)
    private Role role;

    @OneToMany(mappedBy = "fromUser")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "toUser")
    private List<Message> receivedMessages;

    @Override
    public Collection<Role> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
