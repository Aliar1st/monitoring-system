package loc.aliar.monitoringsystem.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Statement extends AbstractModel {
    @Column(columnDefinition = "text", nullable = false)
    private String statement;

    @Column(columnDefinition = "text", nullable = false)
    private String recommendation;

    @Column(unique = true, nullable = false)
    private Byte borgResult;

    public Statement(Long id) {
        setId(id);
    }
}
