package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Position;
import loc.aliar.monitoringsystem.model.PositionModel;
import org.springframework.core.convert.converter.Converter;

public class ModelToPositionConverter implements Converter<PositionModel, Position> {
    @Override
    public Position convert(PositionModel source) {
        return Position.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
