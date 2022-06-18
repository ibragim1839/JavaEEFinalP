package Project.Core.Servlets;

import Project.Core.Manager.Connector;
import Project.Core.Models.Client;
import Project.Core.Models.Deal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDeal")

public class addDeal extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Deal newDeal = new Deal();

        newDeal.setMain(req.getParameter("header"));
        newDeal.setShortDescription(req.getParameter("short_description"));
        newDeal.setDescription(req.getParameter("description"));
        newDeal.setPrice(Integer.parseInt(req.getParameter("price")));
        newDeal.setPicture1(req.getParameter("pic1"));
        newDeal.setPicture2(req.getParameter("pic2"));
        newDeal.setPicture3(req.getParameter("pic3"));

        Client c = new Client();
        c.setId((Long.parseLong(req.getParameter("client"))));
        newDeal.setClient(c);

        Connector.addDeal(newDeal);

        resp.sendRedirect("/admin?req=deals");
    }
}
