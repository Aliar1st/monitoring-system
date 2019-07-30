package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.CardioMedicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardioMedicalInfoRepository extends JpaRepository<CardioMedicalInfo, Long> {

}
