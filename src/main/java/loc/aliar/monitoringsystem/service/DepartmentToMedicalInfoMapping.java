package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.domain.Department;
import loc.aliar.monitoringsystem.service.admin.CardioMedInfoService;
import loc.aliar.monitoringsystem.service.admin.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DepartmentToMedicalInfoMapping {
    private final CardioMedInfoService cardioMedInfoService;

    private Map<Integer, CrudService<?, ?>> DEP_TO_MEDINFO = new HashMap<>();

    @PostConstruct
    private void init() {
        DEP_TO_MEDINFO.put(Department.Departments.CARDIO.getId(), cardioMedInfoService);
    }

    public CrudService<?, ?> getMedInfo(Integer depId) {
        return DEP_TO_MEDINFO.get(depId);
    }
}
