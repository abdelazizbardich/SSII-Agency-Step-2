<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: azizt
  Date: 2/17/2022
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Employees List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="bg-dark">
<div class="container">
    <div class="row vh-100 py-5 align-items-center justify-content-center">
        <div class="col-md-12 text-center text-white p-3 border border-white rounded-3">
            <h1 class="h1">Employees List</h1>
            <p class="small text-white">List for all employees</p>
            <a class="btn btn-lg btn-primary mb-3" href="${pageContext.request.contextPath}/employee/add">Add Employee</a>
            <div class="table-responsive">
                <table class="table table-striped table-light border rounded-3">
                    <thead>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Status</th>
                        <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="var" items="${employees}">
                        <tr>
                            <td>admin fname</td>
                            <td>admin lname</td>
                            <td>admin email</td>
                            <td>admin address</td>
                            <td>Admin status</td>
                            <td>
                                <a class="btn btn-primary btn-sm m-1" href="${pageContext.request.contextPath}/employee/update/1">update</a>
                                <a class="btn btn-danger btn-sm m-1" href="${pageContext.request.contextPath}/employee/delete/1">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
