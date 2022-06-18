package Project.Core.Servlets;

import Project.Core.Manager.Connector;
import Project.Core.Models.Client;
import Project.Core.Models.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.CaretListener;
import java.io.IOException;
import java.util.zip.CheckedOutputStream;

@WebServlet("/registration")

public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Client newClient = new Client();

        newClient.setName(req.getParameter("name"));
        newClient.setCompany(req.getParameter("company"));

        newClient.setCountry(Connector.getCountry(Long.parseLong(req.getParameter("country"))));

        newClient.setLogin(req.getParameter("new_login"));
        newClient.setPassword(req.getParameter("new_password"));
        
        Connector.addClient(newClient);


        if(Connector.login(newClient.getLogin() , newClient.getPassword())!=null){
            HttpSession session = req.getSession();
            session.setAttribute("currentClient", Connector.login(newClient.getLogin() , newClient.getPassword()));
            resp.sendRedirect("/profile");
        }
    }
}
