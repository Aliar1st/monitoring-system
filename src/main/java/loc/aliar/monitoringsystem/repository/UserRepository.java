package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findAllByRoleId(Integer roleId);

    boolean existsByUsername(String username);

    @Query("select count(p) > 0 from Patient p join p.doctors d where p.id = :patientId and d.id = :doctorId")
    boolean isDoctorPatient(Long doctorId, Long patientId);
}
