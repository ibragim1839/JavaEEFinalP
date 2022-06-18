package Project.Core.Servlets;

import Project.Core.Manager.Connector;
import Project.Core.Models.Client;
import Project.Core.Models.Comment;
import Project.Core.Models.Country;
import Project.Core.Models.Deal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin")

public class admin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if (req.getParameter("req") != null) {
            String requirement = (String) req.getParameter("req");

            if (requirement.equals("countries")) {
                if (Connector.getAllCountries() != null) {
                    ArrayList<Country> listToShow = Connector.getAllCountries();
                    req.setAttribute("listToShow", listToShow);
                    req.getRequestDispatcher("/adminCountries.jsp").forward(req, resp);
                }

            }else if (requirement.equals("deals")) {
                if (Connector.getAllDeals() != null) {
                    if (Connector.getAllClients() != null) {
                        req.setAttribute("clients", Connector.getAllClients());
                    }
                    if (Connector.getAllCountries() != null) {
                        req.setAttribute("countries", Connector.getAllCountries());
                    }
                    ArrayList<Deal> listToShow = Connector.getAllDeals();
                    req.setAttribute("listToShow", listToShow);
                    req.getRequestDispatcher("/adminDeals.jsp").forward(req, resp);
                }
            }
            else if (requirement.equals("clients")) {
                if (Connector.getAllClients() != null) {
                    ArrayList<Client> listToShow = Connector.getAllClients();
                    req.setAttribute("listToShow", listToShow);
                    req.getRequestDispatcher("/adminClients.jsp").forward(req, resp);
                }
            }



        } else {
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        }

    }
}
