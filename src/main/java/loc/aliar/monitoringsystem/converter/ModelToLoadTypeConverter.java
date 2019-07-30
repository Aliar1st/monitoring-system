package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.LoadType;
import loc.aliar.monitoringsystem.model.LoadTypeModel;
import org.springframework.core.convert.converter.Converter;

public class ModelToLoadTypeConverter implements Converter<LoadTypeModel, LoadType> {
    @Override
    public LoadType convert(LoadTypeModel source) {
        return LoadType.builder()
                .name(source.getName())
                .build();
    }
}
