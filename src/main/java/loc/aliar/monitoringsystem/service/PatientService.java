package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.model.PatientModel;

import java.util.List;

public interface PatientService {
    Object getMedicalInfo(Integer depId);

    List<PatientModel> getAllByDoctorId(Long doctorId);
}
