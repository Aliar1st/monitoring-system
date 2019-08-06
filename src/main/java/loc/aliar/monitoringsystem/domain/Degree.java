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
public class Degree extends AbstractModel {
    @Column(unique = true, length = 30, nullable = false)
    private String name;

    public Degree(Long id) {
        setId(id);
    }

    @Builder
    public Degree(Long id, String name) {
        super(id);
        this.name = name;
    }
}
