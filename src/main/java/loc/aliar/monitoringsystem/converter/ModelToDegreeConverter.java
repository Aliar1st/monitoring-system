package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Degree;
import loc.aliar.monitoringsystem.model.DegreeModel;
import org.springframework.core.convert.converter.Converter;

public class ModelToDegreeConverter implements Converter<DegreeModel, Degree> {
    @Override
    public Degree convert(DegreeModel source) {
        return Degree.builder()
                .name(source.getName())
                .build();
    }
}
