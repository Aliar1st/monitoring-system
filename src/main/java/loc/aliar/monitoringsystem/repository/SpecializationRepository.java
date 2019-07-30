package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    boolean existsByName(String name);
}
