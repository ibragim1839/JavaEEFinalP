package Project.Core.Servlets;

import Project.Core.Manager.Connector;
import Project.Core.Models.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCountry")

public class addCountry extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Country newCountry = new Country();
        if(req.getParameter("name")!=null){
            String name = req.getParameter("name");
            newCountry.setName(name);
            Connector.addCounty(newCountry);
            resp.sendRedirect("/admin?req=countries");
        }
    }
}
