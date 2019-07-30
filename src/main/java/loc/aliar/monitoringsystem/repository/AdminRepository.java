package loc.aliar.monitoringsystem.repository;

import loc.aliar.monitoringsystem.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findAllByDepartmentId(Long departmentId);
}
