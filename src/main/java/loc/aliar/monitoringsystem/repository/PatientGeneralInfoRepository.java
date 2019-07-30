package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.PatientGeneralInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientGeneralInfoRepository extends JpaRepository<PatientGeneralInfo, Long> {
}
