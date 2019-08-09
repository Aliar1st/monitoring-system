package loc.aliar.monitoringsystem.converter;

import loc.aliar.monitoringsystem.domain.Statement;
import loc.aliar.monitoringsystem.model.StatementModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ModelToStatementConverter implements Converter<StatementModel, Statement> {
    @Override
    public Statement convert(StatementModel source) {
        return Statement.builder()
                .id(source.getId())
                .statement(source.getStatement())
                .recommendation(source.getRecommendation())
                .borgResult(source.getBorgResult())
                .build();
    }
}
