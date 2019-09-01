package loc.aliar.monitoringsystem.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepartmentIdentificationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer departmentId = (Integer) request.getSession().getAttribute(Constants.DEP_ATTR);

        if (departmentId != null) {
            return true;
        }

        response.sendRedirect("/");
        return false;
    }
}
