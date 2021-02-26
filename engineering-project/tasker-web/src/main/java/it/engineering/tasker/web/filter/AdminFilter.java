package it.engineering.tasker.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        if (path.equals("/login")){
            chain.doFilter(request, response);
        } else {
            HttpSession session = req.getSession();
            String role = session.getAttribute("role").toString();

            if ("admin".equals(role)){
                chain.doFilter(request, response);
            } else {
                req.getRequestDispatcher(path).forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
