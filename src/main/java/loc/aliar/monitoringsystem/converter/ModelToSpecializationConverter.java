package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Specialization;
import loc.aliar.monitoringsystem.model.SpecializationModel;
import org.springframework.core.convert.converter.Converter;

public class ModelToSpecializationConverter implements Converter<SpecializationModel, Specialization> {
    @Override
    public Specialization convert(SpecializationModel source) {
        return Specialization.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
