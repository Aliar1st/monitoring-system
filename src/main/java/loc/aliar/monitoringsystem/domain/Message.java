package loc.aliar.monitoringsystem.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
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

    @Builder
    public Message(Long id, String body, Boolean isRead, User fromUser, User toUser) {
        super(id);
        this.body = body;
        this.isRead = isRead;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}
