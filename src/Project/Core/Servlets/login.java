package Project.Core.Servlets;


import Project.Core.Manager.Connector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")

public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");

        if(Connector.login(login, password)!=null){
            HttpSession session = req.getSession();
            session.setAttribute("currentClient", Connector.login(login, password));
            resp.sendRedirect("/profile");
        }


    }
}
