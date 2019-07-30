package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {
    boolean existsByBorgResult(Byte borgResult);
}
