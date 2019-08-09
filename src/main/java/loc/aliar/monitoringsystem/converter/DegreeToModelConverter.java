package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Degree;
import loc.aliar.monitoringsystem.model.DegreeModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DegreeToModelConverter implements Converter<Degree, DegreeModel> {
    @Override
    public DegreeModel convert(Degree source) {
        return DegreeModel.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
