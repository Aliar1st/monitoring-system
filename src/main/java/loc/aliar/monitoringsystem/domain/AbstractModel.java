package loc.aliar.monitoringsystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractModel implements Persistable<Long>, Auditable<User, Long, LocalDateTime> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @CreatedBy
    private User createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @ManyToOne
    @LastModifiedBy
    private User lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public AbstractModel(Long id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return getId() == null;
    }

    public Optional<User> getCreatedBy() {
        return Optional.ofNullable(createdBy);
    }

    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.ofNullable(createdDate);
    }

    public Optional<User> getLastModifiedBy() {
        return Optional.ofNullable(lastModifiedBy);
    }

    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.ofNullable(lastModifiedDate);
    }
}
