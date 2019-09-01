package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.domain.Role;
import loc.aliar.monitoringsystem.domain.User;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.model.PatientModel;

public interface SecurityService {
    User getUser();

    Long getId();

    AdminModel getAdminModel();

    DoctorModel getDoctorModel();

    PatientModel getPatientModel();

    Role.Roles getRole();

    boolean isSuperAdmin();

    boolean isAdmin();

    boolean isDoctor();

    boolean isPatient();
}
