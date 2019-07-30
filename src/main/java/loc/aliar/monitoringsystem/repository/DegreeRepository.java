package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
    boolean existsByName(String name);
}
