package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Position;
import loc.aliar.monitoringsystem.model.PositionModel;
import org.springframework.core.convert.converter.Converter;

public class PositionToModelConverter implements Converter<Position, PositionModel> {
    @Override
    public PositionModel convert(Position source) {
        return PositionModel.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
