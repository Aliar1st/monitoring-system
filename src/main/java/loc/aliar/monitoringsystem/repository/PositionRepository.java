package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    boolean existsByName(String name);
}
