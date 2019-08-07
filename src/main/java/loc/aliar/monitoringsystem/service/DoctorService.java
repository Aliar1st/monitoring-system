package loc.aliar.monitoringsystem.service;

public interface DoctorService {
    boolean isDoctorPatient(Long doctorId, Long patientId);
}
