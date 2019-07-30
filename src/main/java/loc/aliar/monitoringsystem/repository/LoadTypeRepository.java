package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.LoadType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadTypeRepository extends JpaRepository<LoadType, Long> {
    boolean existsByName(String name);
}
