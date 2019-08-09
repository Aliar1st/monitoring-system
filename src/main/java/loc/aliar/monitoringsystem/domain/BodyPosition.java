package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BodyPosition extends AbstractModel {
    @Column(unique = true, length = 20, nullable = false)
    private String name;

    public BodyPosition(Long id) {
        super(id);
    }

    @Builder
    public BodyPosition(Long id, String name) {
        super(id);
        this.name = name;
    }
}
