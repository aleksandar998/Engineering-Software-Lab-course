package it.engineering.tasker.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.engineering.tasker.common.model.User;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "/*" })
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		if (path.equals("/") || path.equals("/login")) {
			// Further Processing
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				req.getRequestDispatcher("/index.html").forward(request, response);
			}
		}
	}

	@Override
	public void destroy() {
	}

}
