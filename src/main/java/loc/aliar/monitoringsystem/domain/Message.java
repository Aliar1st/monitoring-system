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
public class Message extends AbstractModel {
    @Column(columnDefinition = "text", nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean isRead;

    @ManyToOne(optional = false)
    private User fromUser;

    @ManyToOne(optional = false)
    private User toUser;
}
