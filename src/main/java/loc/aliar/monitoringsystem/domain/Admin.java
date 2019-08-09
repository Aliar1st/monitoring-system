package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Admin extends AbstractModel {
    //    @ManyToOne(optional = false)
    @ManyToOne
    private Department department;

    @OneToOne(optional = false)
    private User user;

    @Builder
    public Admin(Long id, Department department, User user) {
        super(id);
        this.department = department;
        this.user = user;
    }
}
