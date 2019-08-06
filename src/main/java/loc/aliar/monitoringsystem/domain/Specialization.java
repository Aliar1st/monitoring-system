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
public class Specialization extends AbstractModel {
    @Column(unique = true, length = 50, nullable = false)
    private String name;

    public Specialization(Long id) {
        setId(id);
    }

    @Builder
    public Specialization(Long id, String name) {
        super(id);
        this.name = name;
    }
}
