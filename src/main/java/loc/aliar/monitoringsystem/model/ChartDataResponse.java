package loc.aliar.monitoringsystem.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class ChartDataResponse {
    private final boolean success;
    private BindingResult bindingResult;

    private String type;
    private List<String> labels = new ArrayList<>();
    private List<Byte> data = new ArrayList<>();
    private List<Byte> redLine;


}
