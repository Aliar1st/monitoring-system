package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.model.ChartDataRequest;
import loc.aliar.monitoringsystem.model.ChartDataResponse;
import loc.aliar.monitoringsystem.model.ReadingModel;
import loc.aliar.monitoringsystem.service.ReadingService;
import loc.aliar.monitoringsystem.service.SecurityService;
import loc.aliar.monitoringsystem.service.admin.BodyPositionService;
import loc.aliar.monitoringsystem.service.admin.LoadService;
import loc.aliar.monitoringsystem.service.admin.LoadTypeService;
import loc.aliar.monitoringsystem.service.admin.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/readings")
@RequiredArgsConstructor
public class ReadingController {
    private final BodyPositionService bodyPositionService;
    private final LoadService loadService;
    private final LoadTypeService loadTypeService;
    private final StatementService statementService;
    private final ReadingService readingService;
    private final SecurityService securityService;

    @GetMapping
    public String index(Model model) {
        model
                .addAttribute("readings", securityService.getPatient().getReadings())
                .addAttribute("loadTypes", loadTypeService.getAll());
        return "";
    }

    @GetMapping("chartData")
    @ResponseBody
    public ChartDataResponse chartData(@Valid ChartDataRequest chartDataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ChartDataResponse chartDataResponse = new ChartDataResponse(false);
            chartDataResponse.setBindingResult(bindingResult);
            return chartDataResponse;
        }

        return readingService.chartData(chartDataRequest.getPatientId(),
                chartDataRequest.getLoadTypeId(), chartDataRequest.getStart(), chartDataRequest.getEnd());
    }

    @GetMapping("/create")
    public String create(Model model) {
        Long patientId = securityService.getPatient().getId();
        Optional<ReadingModel> lastReading = readingService.getLastByPatientId(patientId);

        lastReading.ifPresent(readingModel -> model
                .addAttribute("growth", readingModel.getGrowth())
                .addAttribute("weight", readingModel.getWeight()));
        model
                .addAttribute("bodyPositions", bodyPositionService.getAll())
                .addAttribute("loadTypes", loadTypeService.getAll())
                .addAttribute("loads", loadService.getAll())
                .addAttribute("statements", statementService.getAll());

        return "";
    }

    @PostMapping
    public String create(@Valid ReadingModel readingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "";
        }

        readingService.save(readingModel);

        return "";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute(readingService.get(id));
        return "";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        readingService.delete(id);
        return "";
    }
}
