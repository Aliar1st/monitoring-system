package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.LoadType;
import loc.aliar.monitoringsystem.model.LoadTypeModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LoadTypeToModelConverter implements Converter<LoadType, LoadTypeModel> {
    @Override
    public LoadTypeModel convert(LoadType source) {
        return LoadTypeModel.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
