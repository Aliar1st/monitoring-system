package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Education;
import loc.aliar.monitoringsystem.model.EducationModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EducationToModelConverter implements Converter<Education, EducationModel> {
    @Override
    public EducationModel convert(Education source) {
        return EducationModel.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
