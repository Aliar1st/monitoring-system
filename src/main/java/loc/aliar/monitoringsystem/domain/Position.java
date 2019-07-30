package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Position extends AbstractModel {
    @Column(unique = true, length = 70, nullable = false)
    private String name;

    public Position(Long id) {
        setId(id);
    }
}
