package it.engineering.tasker.web.servlet;

import it.engineering.tasker.app.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show-users")
public class ShowUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        req.setAttribute("users", userService.findAll());
        req.getRequestDispatcher("/show-users.jsp").forward(req, resp);
    }
}
