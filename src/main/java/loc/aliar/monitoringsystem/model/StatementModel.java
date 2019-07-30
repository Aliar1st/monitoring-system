package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.StatementRepository;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatementModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4)
    private String statement;

    @NotEmpty
    @Size(min = 4)
    private String recommendation;

    @NotNull
    @Min(6)
    @Max(20)
    @Unique(value = StatementRepository.class,
            fieldName = "borgResult",
            fieldClass = Byte.class)
    private Byte borgResult;
}
