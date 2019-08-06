package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Education;
import loc.aliar.monitoringsystem.model.EducationModel;
import org.springframework.core.convert.converter.Converter;

public class ModelToEducationConverter implements Converter<EducationModel, Education> {
    @Override
    public Education convert(EducationModel source) {
        return Education.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
