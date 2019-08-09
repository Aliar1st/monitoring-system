package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Load;
import loc.aliar.monitoringsystem.domain.LoadType;
import loc.aliar.monitoringsystem.model.LoadModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToLoadConverter implements Converter<LoadModel, Load> {
    @Override
    public Load convert(LoadModel source) {
        return Load.builder()
                .id(source.getId())
                .name(source.getName())
                .loadType(new LoadType(source.getLoadTypeId()))
                .build();
    }
}
