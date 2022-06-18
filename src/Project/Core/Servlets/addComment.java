package Project.Core.Servlets;

import Project.Core.Manager.Connector;
import Project.Core.Models.Client;
import Project.Core.Models.Comment;
import Project.Core.Models.Deal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UTFDataFormatException;

@WebServlet("/addComment")

public class addComment extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Comment newComment = new Comment();

        newComment.setComment(req.getParameter("comment"));

        Client theClient = (Client) req.getSession().getAttribute("currentClient");
        newComment.setClient(theClient);

        Deal theDeal = new Deal();
        theDeal.setId(Long.parseLong(req.getParameter("id")));

        newComment.setDeal(theDeal);

        Connector.addComment(newComment);

        resp.sendRedirect("http://localhost:8080/details?id="+theDeal.getId());
    }
}
