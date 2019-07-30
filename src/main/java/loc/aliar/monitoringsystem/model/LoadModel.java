package loc.aliar.monitoringsystem.model;

import loc.aliar.monitoringsystem.repository.LoadRepository;
import loc.aliar.monitoringsystem.repository.LoadTypeRepository;
import loc.aliar.monitoringsystem.validation.annotation.Exists;
import loc.aliar.monitoringsystem.validation.annotation.Unique;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoadModel implements IdAble {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 100)
    @Unique(LoadRepository.class)
    private String name;

    @NotNull
    @Exists(LoadTypeRepository.class)
    private Long loadTypeId;
}
