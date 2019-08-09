package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.BodyPosition;
import loc.aliar.monitoringsystem.model.BodyPositionModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BodyPositionToModelConverter implements Converter<BodyPosition, BodyPositionModel> {
    @Override
    public BodyPositionModel convert(BodyPosition source) {
        return BodyPositionModel.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
