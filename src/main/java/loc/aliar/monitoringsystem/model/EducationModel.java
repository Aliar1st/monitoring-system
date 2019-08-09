package loc.aliar.monitoringsystem.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 30)
    private String name;
}
