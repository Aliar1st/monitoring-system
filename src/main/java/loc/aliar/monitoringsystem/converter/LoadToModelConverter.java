package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Load;
import loc.aliar.monitoringsystem.model.LoadModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LoadToModelConverter implements Converter<Load, LoadModel> {
    @Override
    public LoadModel convert(Load source) {
        return LoadModel.builder()
                .id(source.getId())
                .name(source.getName())
                .loadTypeId(source.getLoadType().getId())
                .build();
    }
}
