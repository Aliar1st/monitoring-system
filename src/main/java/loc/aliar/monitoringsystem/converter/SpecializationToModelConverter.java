package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Specialization;
import loc.aliar.monitoringsystem.model.SpecializationModel;
import org.springframework.core.convert.converter.Converter;

public class SpecializationToModelConverter implements Converter<Specialization, SpecializationModel> {
    @Override
    public SpecializationModel convert(Specialization source) {
        return SpecializationModel.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
