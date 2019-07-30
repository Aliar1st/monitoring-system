package loc.aliar.monitoringsystem.config;

import loc.aliar.monitoringsystem.converter.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final AdminModelToUserConverter adminModelToUserConverter;
    private final DoctorModelToUserConverter doctorModelToUserConverter;
    private final PatientModelToGeneralInfoConverter patientModelToGeneralInfoConverter;
    private final PatientModelToUserConverter patientModelToUserConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new AdminModelToAdminConverter());
        registry.addConverter(adminModelToUserConverter);
        registry.addConverter(new AdminToModelConverter());
        registry.addConverter(new BodyPositionToModelConverter());
        registry.addConverter(new DegreeToModelConverter());
        registry.addConverter(new DoctorModelToDoctorConverter());
        registry.addConverter(doctorModelToUserConverter);
        registry.addConverter(new DoctorToModelConverter());
        registry.addConverter(new EducationToModelConverter());
        registry.addConverter(new LoadToModelConverter());
        registry.addConverter(new LoadTypeToModelConverter());
        registry.addConverter(new ModelToBodyPositionConverter());
        registry.addConverter(new ModelToDegreeConverter());
        registry.addConverter(new ModelToEducationConverter());
        registry.addConverter(new ModelToLoadConverter());
        registry.addConverter(new ModelToLoadTypeConverter());
        registry.addConverter(new ModelToPositionConverter());
        registry.addConverter(new ModelToSpecializationConverter());
        registry.addConverter(new ModelToStatementConverter());
        registry.addConverter(patientModelToGeneralInfoConverter);
        registry.addConverter(patientModelToUserConverter);
        registry.addConverter(new PatientToModelConverter());
        registry.addConverter(new PositionToModelConverter());
        registry.addConverter(new SpecializationToModelConverter());
        registry.addConverter(new StatementToModelConverter());
    }
}
