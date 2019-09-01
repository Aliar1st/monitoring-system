package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Load extends AbstractModel {
    @Column(unique = true, length = 255, nullable = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LoadType loadType;

    public Load(Long id) {
        super(id);
    }

    @Builder
    public Load(Long id, String name, LoadType loadType) {
        super(id);
        this.name = name;
        this.loadType = loadType;
    }
}
