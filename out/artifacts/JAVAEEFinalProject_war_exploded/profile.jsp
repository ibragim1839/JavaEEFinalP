<%@ page import="Project.Core.Models.Deal" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ibragim
  Date: 12.06.2022
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="margin-bottom: 100px">
<%@include file="vendors/bootstrap.jsp"%>
<%@include file="vendors/navbar.jsp"%>
<%Client currentClient = (Client) session.getAttribute("currentClient");%>
<div class="container mt-5">
    <div class="text-center">
        <div class="row">
            <div class="col-12">
                <h1><%=currentClient.getName()%></h1>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <h1><%=currentClient.getCompany()%></h1>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <h1><%=currentClient.getCountry().getName()%></h1>
            </div>
        </div>

    </div>


    <div style="padding: 30px; background-color: #f3f8ee; border-radius: 25px"  class="row mt-4">
        <div class="row">
            <div class="col-12">
                <h1>История сделок:</h1>
            </div>
        </div>


        <div class="row mt-2">
            <% ArrayList<Deal> deals = (ArrayList<Deal>) request.getAttribute("dealsOfClient");
                for(Deal d : deals){%>
                    <div class="col-6" >
                        <div style="border: 1px gray solid; border-radius: 10px; display: flex;
                                                flex-direction: column; padding: 15px; width: 500px;
                                                background-color: white" class="mt-3">
                            <h3 style="text-align: left"><%=d.getMain()%></h3>
                            <div style="display: flex; flex-direction: row; justify-content: end" class="mt-3">
                                <img src="<%=d.getPicture1()%>" style="height: 110px; width: 110px;
                                                        object-fit: cover; border-radius: 50%; margin-right: 15px">
                                <img src="<%=d.getPicture2()%>" style="height: 110px; width: 110px;
                                                        object-fit: cover; border-radius: 50%; margin-right: 15px">
                                <img src="<%=d.getPicture3()%>" style="height: 110px; width: 110px;
                                                        object-fit: cover; border-radius: 50%">
                            </div>
                            <p class="mt-3"><%=d.getShortDescription()%></p>
                            <a href="/details?id=<%=d.getId()%>">
                                <button class="btn btn-success" style="width: 120px; height: 50px">
                                    READ
                                </button>
                            </a>
                        </div>
                    </div>
                <%}%>
        </div>
    </div>


</div>

</body>
</html>
