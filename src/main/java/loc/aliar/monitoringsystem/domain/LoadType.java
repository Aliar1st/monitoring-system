package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LoadType extends AbstractModel {
    @Column(unique = true, length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy = "loadType")
    private List<Load> loads;

    public LoadType(Long id) {
        super(id);
    }
}
