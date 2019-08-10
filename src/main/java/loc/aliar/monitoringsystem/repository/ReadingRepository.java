package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Long> {
    Optional<Reading> findFirstByPatientIdOrderByCreatedDate(Long patientId);

    List<Reading> findAllByPatientIdOrderByCreatedDate(Long patientId);

    List<Reading> findAllByPatientIdAndLoadLoadTypeIdAndCreatedDateBetween(
            Long patientId, Long loadTypeId, LocalDateTime start, LocalDateTime end);

    List<Reading> findAllByPatientIdAndCreatedDateBetween(
            Long patientId, LocalDateTime start, LocalDateTime end);
}
