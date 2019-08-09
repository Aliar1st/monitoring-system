package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Education extends AbstractModel {
    @Column(unique = true, length = 30, nullable = false)
    private String name;

    public Education(Long id) {
        super(id);
    }

    @Builder
    public Education(Long id, String name) {
        super(id);
        this.name = name;
    }
}
