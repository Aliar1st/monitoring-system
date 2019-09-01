package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.domain.Doctor;
import loc.aliar.monitoringsystem.model.DoctorModel;

public interface DoctorService extends CrudService<Doctor, DoctorModel> {
    boolean isDoctorPatient(Long doctorId, Long patientId);
}
