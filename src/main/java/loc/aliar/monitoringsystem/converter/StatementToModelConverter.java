package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Statement;
import loc.aliar.monitoringsystem.model.StatementModel;
import org.springframework.core.convert.converter.Converter;

public class StatementToModelConverter implements Converter<Statement, StatementModel> {
    @Override
    public StatementModel convert(Statement source) {
        return StatementModel.builder()
                .id(source.getId())
                .statement(source.getStatement())
                .recommendation(source.getRecommendation())
                .borgResult(source.getBorgResult())
                .build();
    }
}
