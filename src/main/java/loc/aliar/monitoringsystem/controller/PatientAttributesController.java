package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.model.ReadingModel;
import loc.aliar.monitoringsystem.service.ReadingService;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@ControllerAdvice
@RequiredArgsConstructor
public class PatientAttributesController {
    private final SecurityService securityService;
    private final ReadingService readingService;

    @ModelAttribute
    public void unreadCount(Model model) {
        if (securityService.isPatient() || securityService.isDoctor()) {
            model.addAttribute("unreadCount", 5);
        }
    }

    @ModelAttribute
    public void profileCard(Model model) {
        if (securityService.isPatient()) {
            PatientModel patientModel = securityService.getPatientModel();

            String dob = patientModel.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String name = patientModel.fullName();
            String photo = patientModel.getPhotoUrl();

            Optional<ReadingModel> lastReadingOpt = readingService.getLastByPatientId(1L);
            String lastDate;
            String lastTime;
            String lastScore;

            if (lastReadingOpt.isPresent()) {
                ReadingModel lastReading = lastReadingOpt.get();
                lastDate = lastReading.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                lastTime = lastReading.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                lastScore = lastReading.getBorg().toString();
            } else {
                lastDate = lastTime = lastScore = "н/д";
            }

            model.addAttribute("dob", dob)
                    .addAttribute("name", name)
                    .addAttribute("photo", photo)
                    .addAttribute("lastDate", lastDate)
                    .addAttribute("lastTime", lastTime)
                    .addAttribute("lastScore", lastScore);
        }
    }
}
