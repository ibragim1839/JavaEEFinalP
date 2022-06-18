package Project.Core.Servlets;

import Project.Core.Manager.Connector;
import Project.Core.Models.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")

public class profilePage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Client currentClient = (Client) session.getAttribute("currentClient");

        if(currentClient != null){
            if(Connector.getClientsDeals(currentClient.getId())!=null){
                req.setAttribute("dealsOfClient", Connector.getClientsDeals(currentClient.getId()));
            }

            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("404.jsp");
        }

    }
}
