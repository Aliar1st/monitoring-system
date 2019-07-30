package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {
    boolean existsByName(String name);
}
