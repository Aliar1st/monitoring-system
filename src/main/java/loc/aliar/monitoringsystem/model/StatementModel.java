package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.StatementRepository;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.*;

import javax.validation.constraints.*;

@Getter @Setter
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
            fieldName = "lastReadingBorg",
            fieldClass = Byte.class)
    private Byte borgResult;
}
