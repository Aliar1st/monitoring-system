package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Load extends AbstractModel {
    @Column(unique = true, length = 255, nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private LoadType loadType;
}
