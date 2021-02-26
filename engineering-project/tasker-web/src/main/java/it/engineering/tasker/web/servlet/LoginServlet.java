package it.engineering.tasker.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.tasker.app.service.UserService;
import it.engineering.tasker.common.exception.UserException;
import it.engineering.tasker.common.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userService = (UserService) getServletContext().getAttribute("userService");
		try {
			User user = userService.login(username, password);
			// Session
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			req.getRequestDispatcher("/index2.jsp").forward(req, resp);
		} catch (UserException ex) {
			req.setAttribute("errMsg", ex.getMessage());
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}

}
