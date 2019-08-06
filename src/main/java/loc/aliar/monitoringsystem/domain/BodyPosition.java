package loc.aliar.monitoringsystem.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BodyPosition extends AbstractModel {
    @Column(unique = true, length = 20, nullable = false)
    private String name;

    @Builder
    public BodyPosition(Long id, String name) {
        super(id);
        this.name = name;
    }
}
