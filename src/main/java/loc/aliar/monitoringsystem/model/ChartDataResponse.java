package loc.aliar.monitoringsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ChartDataResponse {
    private final boolean success;
    private BindingResult bindingResult;

    private String type;
    private List<String> labels = new ArrayList<>();
    private List<Byte> data = new ArrayList<>();
    private List<Byte> redLine;


}
