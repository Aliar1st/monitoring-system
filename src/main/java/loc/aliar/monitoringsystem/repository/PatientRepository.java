package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.domain.projection.CardPatient;
import loc.aliar.monitoringsystem.domain.projection.CardioCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "select " +
            "p.user_id as id, " +
            "r.created_date as lastReadingDate, " +
            "s.borg_result as lastReadingBorg, " +
            "p.first_name as firstName, " +
            "p.last_name as lastName, " +
            "p.date_of_birth as dateOfBirth, " +
            "p.photo as photo " +
            "from Patient p " +
            "inner join doctor_patients dp on dp.patients_user_id = p.user_id " +
            "inner join doctor d on d.user_id = dp.doctors_user_id " +
            "left join (" +
            "    select top 1 * from cardio_reading r " +
            "    order by r.created_date desc" +
            ") r on r.patient_user_id = p.user_id " +
            "left join statement s on s.id = r.statement_id " +
            "where d.user_id = ?1 " +
            "and d.department_id = ?2 " +
            "order by r.created_date desc", nativeQuery = true)
    List<CardioCard> findCardioCardsByDoctorIdAndDepartmentId(Long doctorId, Integer departmentId);

    @Query("select p " +
            "from Patient p " +
            "inner join p.cardioMedicalInfo " +
            "join fetch p.user")
    List<Patient> findAllInCardioDepartment();

    CardPatient getById(Long id);
}
