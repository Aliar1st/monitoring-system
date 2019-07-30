package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.BodyPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyPositionRepository extends JpaRepository<BodyPosition, Long> {
    boolean existsByName(String name);
}
