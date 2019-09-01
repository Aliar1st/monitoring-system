package loc.aliar.monitoringsystem.controller;

import loc.aliar.monitoringsystem.model.MessageModel;
import loc.aliar.monitoringsystem.service.MessageService;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/patient/chat")
@RequiredArgsConstructor
public class PatientChatController {
    private final SecurityService securityService;
    private final MessageService messageService;

    @GetMapping
    public String index(Model model) {
        Long userId = securityService.getId();

        model
                .addAttribute("messages", messageService.getAllByUserId(userId));

        return "";
    }

    @PostMapping
    public String send(@Valid MessageModel messageModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        }

        messageModel.setFromUserId(securityService.getId());
        messageService.save(messageModel);

        return "";
    }
}
