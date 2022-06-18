<%@ page import="Project.Core.Models.Country" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Project.Core.Models.Client" %>
<%@ page import="Project.Core.Models.Deal" %><%--
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
        <%ArrayList<Deal> deals = (ArrayList<Deal>)request.getAttribute("listToShow");%>
        <table class="table" style="border-spacing: 10px">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">HEADER</th>
                <th scope="col">PRICE</th>
                <th scope="col">PIC1</th>
                <th scope="col">PIC2</th>
                <th scope="col">PIC3</th>
                <th scope="col">CLIENT</th>
                <th scope="col">DELETE</th>
            </tr>
            </thead>

            <tbody>
            <%for(Deal d : deals){%>
            <tr>
                <td height="40px"><%=d.getId()%></td>
                <td height="40px"><%=d.getMain()%></td>
                <td height="40px"><%=d.getPrice()%></td>

                <td height="40px"><img src="<%=d.getPicture1()%>" height="30px"></td>
                <td height="40px"><img src="<%=d.getPicture2()%>" height="30px"></td>
                <td height="40px"><img src="<%=d.getPicture3()%>" height="30px"></td>

                <td height="40px"><%=d.getClient().getName()+"/"+d.getClient().getCompany()%></td>

                <td height="40px">
                    <form method="post" action="/deleteDeal">
                        <input type="text" hidden value="<%=d.getId()%>" name="id">
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
                <h5 class="modal-title" id="staticBackdropLabel">Add a new deal modal window</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

                <form method="post" action="/addDeal">

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">Header of the deal</label>
                        <input type="text" name="header" placeholder="insert header" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">short description</label>
                        <input type="text" name="short_description" placeholder="insert short description<" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">full description</label>
                        <textarea name="description" placeholder="insert full description" class="form-control"></textarea>
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">price</label>
                        <input type="number" name="price" placeholder="insert price" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">Picture 1</label>
                        <input type="text" name="pic1" placeholder="add picture url" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">picture 2</label>
                        <input type="text" name="pic2" placeholder="add picture url" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">picture 3</label>
                        <input type="text" name="pic3" placeholder="add picture url" class="form-control">
                    </div>

                    <div class="from-group mt-3">
                        <label  style="margin-bottom: 10px">Choose a client</label>
                        <select class="form-control" name="client">
                            <%ArrayList<Client> clients = (ArrayList<Client>) request.getAttribute("clients");%>
                            <%if(clients!=null){
                                for(Client c : clients){%>
                            <option value="<%=c.getId()%>">
                                <%=c.getName()+"/"+c.getCompany()%>
                            </option>
                            <%}}%>
                        </select>
                    </div>



                    <button type="submit" class="btn bg-success text-light mt-5">SUBMIT</button>

                </form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
