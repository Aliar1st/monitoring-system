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
public class Reading extends AbstractModel {
    @Column(nullable = false)
    private Short duration;

    @Column(nullable = false)
    private Short growth;

    @Column(nullable = false)
    private Short weight;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Load load;

    @ManyToOne(optional = false)
    private BodyPosition bodyPosition;

    @ManyToOne(optional = false)
    private Statement statement;
}
