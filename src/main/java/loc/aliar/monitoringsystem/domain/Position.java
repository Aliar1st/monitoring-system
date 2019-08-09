package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Position extends AbstractModel {
    @Column(unique = true, length = 70, nullable = false)
    private String name;

    public Position(Long id) {
        setId(id);
    }

    @Builder
    public Position(Long id, String name) {
        super(id);
        this.name = name;
    }
}
