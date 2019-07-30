package loc.aliar.monitoringsystem.service;

import loc.aliar.monitoringsystem.domain.*;
import loc.aliar.monitoringsystem.model.AdminModel;
import loc.aliar.monitoringsystem.model.DoctorModel;
import loc.aliar.monitoringsystem.model.PatientModel;

public interface SecurityService {
    User getUser();

    Admin getAdmin();

    Doctor getDoctor();

    Patient getPatient();

    AdminModel getAdminModel();

    DoctorModel getDoctorModel();

    PatientModel getPatientModel();

    Integer getDepartmentId();

    Role.Roles getRole();

    boolean isSuperAdmin();

    boolean isAdmin();

    boolean isDoctor();

    boolean isPatient();
}
