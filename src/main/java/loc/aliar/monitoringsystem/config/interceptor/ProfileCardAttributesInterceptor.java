package loc.aliar.monitoringsystem.config.interceptor;

import loc.aliar.monitoringsystem.domain.Patient;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.model.ReadingModel;
import loc.aliar.monitoringsystem.service.ReadingService;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfileCardAttributesInterceptor extends HandlerInterceptorAdapter {
    private final ReadingService readingService;
    private final SecurityService securityService;
    private final ConversionService conversionService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Patient patient = securityService.getPatient();
        PatientModel patientModel = conversionService.convert(patient, PatientModel.class);

        String dob = patientModel.getDateOfBirth().format(null);
        String name = patientModel.fullName();
        String photo = patientModel.getPhotoUrl();

        Optional<ReadingModel> lastReadingOpt = readingService.getLastByPatientId(patient.getId());
        String lastDate;
        String lastTime;
        String lastScore;

        if (lastReadingOpt.isPresent()) {
            ReadingModel lastReading = lastReadingOpt.get();
            lastDate = lastReading.getDate().format(null);
            lastTime = lastReading.getDate().format(null);
            lastScore = lastReading.getBorg().toString();
        } else {
            lastDate = lastTime = lastScore = "н/д";
        }

        request.setAttribute("dob", dob);
        request.setAttribute("name", name);
        request.setAttribute("photo", photo);
        request.setAttribute("lastDate", lastDate);
        request.setAttribute("lastTime", lastTime);
        request.setAttribute("lastScore", lastScore);
    }
}
