package it.engineering.tasker.web.servlet;

import it.engineering.tasker.app.service.UserService;
import it.engineering.tasker.common.exception.UserException;
import it.engineering.tasker.common.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = (UserService) getServletContext().getAttribute("userService");

        try {
            User user = userService.save(new User(0, name, username, password));
            session.setAttribute("user", user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (UserException e){
            req.setAttribute("errMsg", e.getMessage());
            req.getRequestDispatcher("/create-user.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }
}
