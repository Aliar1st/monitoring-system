package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.model.CardioCardModel;
import loc.aliar.monitoringsystem.model.PatientModel;
import loc.aliar.monitoringsystem.service.CardioReadingService;
import loc.aliar.monitoringsystem.service.PatientService;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static loc.aliar.monitoringsystem.config.Constants.DATETIME_FORMAT;
import static loc.aliar.monitoringsystem.config.Constants.DATE_FORMAT;

@ControllerAdvice(basePackageClasses = {
        PatientController.class,
        CardioReadingController.class
})
@RequiredArgsConstructor
public class PatientAttributesController {
    private static final String DATE_OF_BIRTH_ATTR = "dob";
    private static final String NAME_ATTR = "name";
    private static final String PHOTO_ATTR = "photo";
    private static final String LAST_READING_DATE_ATTR = "lastDate";
    private static final String LAST_BORG_SCORE_ATTR = "lastScore";

    private final SecurityService securityService;
    private final PatientService patientService;
    private final CardioReadingService cardioReadingService;

    @ModelAttribute
    public void unreadCount(Authentication authentication, Model model) {
        if (authentication == null || !(securityService.isPatient() || securityService.isDoctor())) {
            return;
        }

        model.addAttribute("unreadCount", 5);
    }

    @ModelAttribute
    public void profileCard(Authentication authentication, Model model, HttpServletRequest request) {
        if (authentication == null || !securityService.isPatient()) {
            return;
        }

        Optional<CardioCardModel> card = cardioReadingService.getCardByPatientId(securityService.getId());

        if (card.isPresent()) {
            addAttributesFromCard(card.get(), model);
        } else {
            PatientModel patientModel = patientService.getForCard(securityService.getId());
            addAttributesFromPatientModel(patientModel, model);
        }

        model.addAttribute("lastTime", model.asMap().get(LAST_READING_DATE_ATTR));
    }

    private void addAttributesFromCard(CardioCardModel cardModel, Model model) {
        model.addAttribute(DATE_OF_BIRTH_ATTR, cardModel.getDateOfBirth().format(DATE_FORMAT));
        model.addAttribute(NAME_ATTR, cardModel.getFullName());
        model.addAttribute(PHOTO_ATTR, cardModel.getPhoto());
        model.addAttribute(LAST_READING_DATE_ATTR, cardModel.getLastReadingDate().format(DATETIME_FORMAT));
        model.addAttribute(LAST_BORG_SCORE_ATTR, cardModel.getLastReadingBorg());
    }

    private void addAttributesFromPatientModel(PatientModel patientModel, Model model) {
        model.addAttribute(DATE_OF_BIRTH_ATTR, patientModel.getDateOfBirth().format(DATE_FORMAT));
        model.addAttribute(NAME_ATTR, patientModel.getFullName());
        model.addAttribute(PHOTO_ATTR, patientModel.getPhotoUrl());
    }
}
