package loc.aliar.monitoringsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 30)
    private String name;
}
