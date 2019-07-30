package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
