package loc.aliar.monitoringsystem.config.interceptor;

import loc.aliar.monitoringsystem.service.MessageService;
import loc.aliar.monitoringsystem.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class NavbarAttributesInterceptor extends HandlerInterceptorAdapter {
    private final MessageService messageService;
    private final SecurityService securityService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {
//        Long userId = securityService.getUser().getId();
//        Long unreadCount = messageService.unreadCount(userId);
        request.setAttribute("unreadCount", 5);
    }
}
