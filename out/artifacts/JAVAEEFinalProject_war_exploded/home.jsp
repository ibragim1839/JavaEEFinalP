<%@ page import="java.util.ArrayList" %>
<%@ page import="Project.Core.Models.Deal" %><%--
  Created by IntelliJ IDEA.
  User: Ibragim
  Date: 11.06.2022
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="vendors/bootstrap.jsp"%>
</head>
    <body  style="margin-bottom: 100px">
    <%@include file="vendors/navbar.jsp"%>
            <div class="container">
                <div class="row">

                        <%ArrayList<Deal> allDeals = (ArrayList<Deal>) request.getAttribute("allDeals");
                            for(Deal d : allDeals){%>

                    <div class="col-6 mx-auto">

                        <div style="border: 1px gray solid; border-radius: 10px; display: flex;
                                flex-direction: column; padding: 15px; width: 600px;" class="mt-3">

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
    </body>
</html>
