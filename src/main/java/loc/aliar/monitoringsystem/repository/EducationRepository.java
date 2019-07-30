package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    boolean existsByName(String name);
}
