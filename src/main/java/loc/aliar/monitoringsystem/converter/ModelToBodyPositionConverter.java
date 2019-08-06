package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.BodyPosition;
import loc.aliar.monitoringsystem.model.BodyPositionModel;
import org.springframework.core.convert.converter.Converter;

public class ModelToBodyPositionConverter implements Converter<BodyPositionModel, BodyPosition> {
    @Override
    public BodyPosition convert(BodyPositionModel source) {
        return BodyPosition.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
