package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.LoadType;
import loc.aliar.monitoringsystem.model.LoadTypeModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToLoadTypeConverter implements Converter<LoadTypeModel, LoadType> {
    @Override
    public LoadType convert(LoadTypeModel source) {
        return LoadType.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
