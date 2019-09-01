package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.CardioReading;
import loc.aliar.monitoringsystem.domain.projection.CardioCard;
import loc.aliar.monitoringsystem.domain.projection.CardioReadingLastParams;
import loc.aliar.monitoringsystem.utils.CollectionUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardioReadingRepository extends JpaRepository<CardioReading, Long> {
    @Query("select " +
            "r.createdDate as lastReadingDate, " +
            "s.borgResult as lastReadingBorg, " +
            "p.firstName as firstName, " +
            "p.lastName as lastName, " +
            "p.dateOfBirth as dateOfBirth, " +
            "p.photo as photo " +
            "from CardioReading r " +
            "inner join r.patient p " +
            "inner join r.statement s " +
            "where p.id = ?1 " +
            "order by r.createdDate desc")
    List<CardioCard> findLastReadingAndPatientByPatientId(Long patientId, Pageable pageable);

    default Optional<CardioCard> findLastReadingAndPatientByPatientId(Long patientId) {
        List<CardioCard> cardioCards = findLastReadingAndPatientByPatientId(patientId, PageRequest.of(0, 1));
        return CollectionUtils.getFirst(cardioCards);
    }

    @Query("select r.weight as weight, r.growth as growth from CardioReading r where r.patient.id = ?1 order by r.createdDate desc")
    List<CardioReadingLastParams> findLastReadingByPatientId(Long patientId, Pageable pageable);

    default Optional<CardioReadingLastParams> findLastReadingByPatientId(Long patientId) {
        List<CardioReadingLastParams> cardioReadings = findLastReadingByPatientId(patientId, PageRequest.of(0, 1));
        return CollectionUtils.getFirst(cardioReadings);
    }

    @EntityGraph(value = CardioReading.NEWG_W_ALL_EX_PATIENT, type = EntityGraph.EntityGraphType.LOAD)
    List<CardioReading> findAllByPatientIdOrderByCreatedDate(Long patientId);

    List<CardioReading> findAllByPatientIdAndLoadLoadTypeIdAndCreatedDateBetween(
            Long patientId, Long loadTypeId, LocalDateTime start, LocalDateTime end);

    List<CardioReading> findAllByPatientIdAndCreatedDateBetween(
            Long patientId, LocalDateTime start, LocalDateTime end);
}
