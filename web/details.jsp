<%@ page import="Project.Core.Models.Deal" %>
<%@ page import="Project.Core.Models.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Ibragim
  Date: 12.06.2022
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body style="margin-bottom: 100px">
<%@include file="vendors/navbar.jsp"%>
<%Deal theDeal = (Deal) request.getAttribute("theDeal");%>
<div class="container mt-5">
    <div class="row">
        <div class="col" style="background-color: #f3f8ee; padding: 50px;">
            <h2>
                По поручению&nbsp;<%=theDeal.getClient().getName()%>&nbsp;из компании&nbsp;<%=theDeal.getClient().getCompany()%>&nbsp;были проведены следующие работы:
            </h2>
            <h5><%=theDeal.getMain()%></h5>
            <h5><%=theDeal.getShortDescription()%></h5>
            <div style="display: flex; justify-content: space-around">
                <div><img src="<%=theDeal.getPicture1()%>" style="height: 150px; width: 150px;
                                        object-fit: cover; border-radius: 50%; margin-right: 15px"></div>
                <div><img src="<%=theDeal.getPicture2()%>" style="height: 150px; width: 150px;
                                        object-fit: cover; border-radius: 50%; margin-right: 15px"></div>
                <div><img src="<%=theDeal.getPicture3()%>" style="height: 150px; width: 150px;
                                        object-fit: cover; border-radius: 50%; margin-right: 15px"></div>
            </div>

            <p><%=theDeal.getDescription()%></p>
        </div>
    </div>


    <%Client currentClient = (Client) session.getAttribute("currentClient");

        if(currentClient!=null){%>

    <form class="mt-3" method="post" action="/addComment">
        <input type="hidden" value="<%=theDeal.getId()%>" name="id">
        <div class="form-group">
            <label style="font-size: 20px">Оставить комментарий:</label>
            <input type="text" class="form-control mt-2" style="height: 100px; max-height: 500px" name="comment">
        </div>
        <div style="text-align: end" class="mt-3">
            <button class="btn btn-success">Оставить комментрий</button>
        </div>
    </form>

    <%}%>
    <%ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");%>
    <%if(comments.isEmpty()){%>
    <h4 style="margin-top: 20px">Комментарии отствуют</h4>
    <%}%>
    <%if(!comments.isEmpty()){%>
    <h4 style="margin-top: 20px">Комментарии:</h4>
    <%}%>
    <%for(Comment c : comments){
    if(Objects.equals(c.getClient().getId(), theDeal.getId())){%>
        <div class="row">
            <div class="col-12" style="background-color: #f8eb86; border-radius: 20px; max-height: 500px; width: 100%;
            padding: 15px; margin-top: 20px">
                <h5><%=c.getClient().getName()%>&nbsp;<%=c.getClient().getCompany()%></h5>
                <p><%=c.getComment()%></p>
                <div style="text-align: right">
                    <span><%=c.getDate()%></span>
                </div>

            </div>
        </div>
    <%}}%>

    <%for(Comment c : comments){
        if(!Objects.equals(c.getClient().getId(), theDeal.getId())){%>
        <div class="row">
            <div class="col-12" style="background-color: lightblue; border-radius: 20px; max-height: 500px; width: 100%;
    padding: 15px; margin-top: 20px">
                <h5><%=c.getClient().getName()%>&nbsp;<%=c.getClient().getCompany()%></h5>
                <p><%=c.getComment()%></p>
                <div style="text-align: right">
                    <span><%=c.getDate()%></span>
                </div>

            </div>
    </div>
    <%}}%>





</div>


</body>
</html>
