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
                        <th>Entry date</th>
                        <th>Address</th>
                        <th>Status</th>
                        <th></th>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employees}">
                        <tr>
                            <td>${employee.getFirstName()}</td>
                            <td>${employee.getLastName()}</td>
                            <td>${employee.getEmail()}</td>
                            <td>${employee.getEntryDate()}</td>
                            <td>${employee.getAddress().getPostalCode()} - ${employee.getAddress().getStreet()} - ${employee.getAddress().getCity()} - ${employee.getAddress().getCountry()}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${employee.isGoneOut() == false}">
                                        <span class="badge bg-success p-1 text-white">Working</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge bg-danger p-1 text-white">Gone out</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${employee.isGoneOut() == false}">
                                        <a class="btn btn-dark btn-sm m-1" href="${pageContext.request.contextPath}/employee/gone-out/${employee.getIdUser()}">set Gone out</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="btn btn-success btn-sm m-1" href="${pageContext.request.contextPath}/employee/working/${employee.getIdUser()}">Set Wokring</a>
                                    </c:otherwise>
                                </c:choose>
                                <a class="btn btn-primary btn-sm m-1" href="${pageContext.request.contextPath}/employee/update/${employee.getIdUser()}">update</a>
                                <a class="btn btn-danger btn-sm m-1" href="${pageContext.request.contextPath}/employee/delete/${employee.getIdUser()}">Delete</a>
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
