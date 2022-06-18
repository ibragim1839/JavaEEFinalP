package Project.Core.Servlets;

import Project.Core.Manager.Connector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCountry")

public class deleteCountry extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("id")!=null){
            Long id = Long.parseLong(req.getParameter("id"));
            Connector.deleteCountry(id);
            resp.sendRedirect("/admin?req=countries");
        }
    }
}
