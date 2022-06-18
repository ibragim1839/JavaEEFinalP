<%@ page import="Project.Core.Models.Client" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Uzhakhov.I
  Date: 19.06.2022
  Time: 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin clients</title>
</head>
<body>


<%@include file="vendors/bootstrap.jsp"%>
<%@include file="vendors/adminNavbar.jsp"%>
<div class="container-fluid" style="display: flex">
    <div style="width: 20%; border: black 1px solid; height: 1000px">
        <table style="margin-left: 30px; margin-top: 50px; font-size: 15px; border-spacing: 25px; border-collapse: separate">
            <thead>
            <tr>
                <th>ADMIN PANEL</th>
            </tr>
            </thead>
            <tbody>
            <tr><td><a href="/admin?req=countries">COUNTRIES</a></td></tr>
            <tr><td><a href="/admin?req=deals">DEALS</a></td></tr>
            <tr><td><a href="/admin?req=clients">CLIENTS</a></td></tr>
            </tbody>
        </table>
    </div>

    <div style="width: 85%; border: red 1px solid;  height: 1000px; padding: 20px">

        <div style="display: flex; justify-content: space-between">
            <h3 ><strong>CLIENTS</strong></h3>
        </div>
        <%ArrayList<Client> clients = (ArrayList<Client>)request.getAttribute("listToShow");%>
        <table class="table" style="border-spacing: 10px">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">NAME</th>
                <th scope="col">COMPANY</th>
                <th scope="col">COUNTRY</th>
            </tr>
            </thead>

            <tbody>

            <%for(Client c : clients){%>
            <tr>
                <td height="40px"><%=c.getId()%></td>
                <td height="40px"><%=c.getName()%></td>
                <td height="40px"><%=c.getCompany()%></td>
                <td height="40px"><%=c.getCountry().getName()%></td>
            </tr>
            <%}%>

            </tbody>

        </table>
    </div>
</div>

</body>
</html>
