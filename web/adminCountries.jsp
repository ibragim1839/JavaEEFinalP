<%@ page import="Project.Core.Models.Country" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Uzhakhov.I
  Date: 19.06.2022
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin countries</title>
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
            <h3 ><strong>COUNTRIES</strong></h3>
            <button style=" height: 45px" type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                ADD TO COUNTRY+
            </button>
        </div>
        <%ArrayList<Country> countries = (ArrayList<Country>)request.getAttribute("listToShow");%>
        <table class="table" style="border-spacing: 10px">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">NAME</th>
                <th scope="col">EDIT</th>
                <th scope="col">DELETE</th>
            </tr>
            </thead>

            <tbody>
            <%for(Country c : countries){%>
            <tr>
                <td height="40px"><%=c.getId()%></td>
                <td height="40px"><%=c.getName()%></td>

                <td height="40px"><button class="btn bg-success text-light">EDIT</button></td>

                <td height="40px">
                    <form method="post" action="/deleteCountry">
                        <input type="text" hidden value="<%=c.getId()%>" name="id">
                        <button type="submit" class="btn bg-danger text-light">DELETE</button>
                    </form>
                </td>
            </tr>
            <%}%>

            </tbody>

        </table>
    </div>
</div>


<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Add country modal window</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form method="post" action="/addCountry">

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">NAME OF THE COUNTRY</label>
                        <input type="text" name="name" placeholder="insert name" class="form-control">
                    </div>

                    <button type="submit" class="btn bg-success text-light mt-5">SUBMIT</button>

                </form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
