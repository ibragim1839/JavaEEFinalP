package Project.Core.Servlets;

import Project.Core.Manager.Connector;
import Project.Core.Models.Comment;
import Project.Core.Models.Deal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/details")

public class detailsPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Connector.getDeal(Long.parseLong(req.getParameter("id")))!=null){
            Deal theDeal = Connector.getDeal(Long.parseLong(req.getParameter("id")));
            req.setAttribute("theDeal", theDeal);
            if(Connector.getComments(theDeal.getId())!=null){
                ArrayList<Comment> comments = Connector.getComments(theDeal.getId());
                req.setAttribute("comments", comments);
            }

            req.getRequestDispatcher("/details.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("404.jsp");
        }
    }
}
