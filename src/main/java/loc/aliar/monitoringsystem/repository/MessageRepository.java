package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findFirstByFromUserIdOrToUserIdOrderByCreatedDate(Long fromUserId, Long toUserId);

    List<Message> findAllByFromUserIdOrToUserId(Long fromUserId, Long toUserId);

    long countAllByToUserIdAndIsReadFalse(Long toUserId);

    @Query(Queries.READ_MESSAGES)
    void readMessages(Long fromUserId, Long toUserId);
}
