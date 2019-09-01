package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("select case when count(d.id) > 0 then true else false end " +
            "from Doctor d " +
            "inner join d.patients p " +
            "where d.id = ?1 " +
            "and p.id = ?2")
    Boolean existsByDoctorIdAndPatientId(Long doctorId, Long patientId);

    List<Doctor> findAllByDepartmentId(Integer departmentId);

//    boolean existsByPatien();
}
