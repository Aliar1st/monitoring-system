package loc.aliar.monitoringsystem.service.impl;

import loc.aliar.monitoringsystem.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    @Override
    public boolean isDoctorPatient(Long doctorId, Long patientId) {
        return false;
    }
}
