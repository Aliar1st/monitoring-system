package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.model.CardioReadingModel;
import loc.aliar.monitoringsystem.model.ChartDataRequest;
import loc.aliar.monitoringsystem.model.ChartDataResponse;
import loc.aliar.monitoringsystem.service.CardioReadingService;
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
@RequestMapping("/cardio-readings")
@RequiredArgsConstructor
public class CardioReadingController {
    private static final String HTML_FOLDER = "readings";

    private final BodyPositionService bodyPositionService;
    private final LoadService loadService;
    private final LoadTypeService loadTypeService;
    private final StatementService statementService;
    private final CardioReadingService cardioReadingService;
    private final SecurityService securityService;

    @GetMapping
    public String index(Model model) {
        Long patientId = securityService.getId();
        model
                .addAttribute(cardioReadingService.getByPatientId(patientId))
                .addAttribute(loadTypeService.getAll())
                .addAttribute(new ChartDataRequest());
        return HTML_FOLDER + "/index";
    }

    @GetMapping("chartData")
    @ResponseBody
    public ChartDataResponse chartData(@Valid ChartDataRequest chartDataRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ChartDataResponse chartDataResponse = new ChartDataResponse(false);
            chartDataResponse.setBindingResult(bindingResult);
            return chartDataResponse;
        }

        return cardioReadingService.chartData(securityService.getId(),
                chartDataRequest.getLoadTypeId(), chartDataRequest.getStart(), chartDataRequest.getEnd());
    }

    @GetMapping("/create")
    public String create(Model model) {
        Long patientId = securityService.getId();
        Optional<CardioReadingModel> lastReading = cardioReadingService.getLastByPatientId(patientId);
        CardioReadingModel cardioReadingModel = lastReading.orElse(new CardioReadingModel());

        setAdditionalAttributes(model);
        model.addAttribute(cardioReadingModel);

        return HTML_FOLDER + "/create";
    }

    private void setAdditionalAttributes(Model model) {
        model
                .addAttribute("bodyPositions", bodyPositionService.getAll())
                .addAttribute("loadTypes", loadTypeService.getAll())
                .addAttribute("loads", loadService.getAll())
                .addAttribute("statements", statementService.getAll());
    }

    @PostMapping
    public String create(
            @Valid CardioReadingModel cardioReadingModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            setAdditionalAttributes(model);
            return HTML_FOLDER + "/create";
        }

        Long patientId = securityService.getId();
        cardioReadingModel.setPatientId(patientId);
        Long id = cardioReadingService.save(cardioReadingModel).getId();

        return "redirect:" + id;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        CardioReadingModel cardioReadingModel = cardioReadingService.get(id);
        model.addAttribute(statementService.get(cardioReadingModel.getStatementId()));
        return HTML_FOLDER + "/result";
    }
}
