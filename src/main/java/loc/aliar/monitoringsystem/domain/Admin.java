package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Admin extends AbstractModel {
    @ManyToOne(optional = false)
    private Department department;

    @OneToOne(optional = false)
    private User user;
}
