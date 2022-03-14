<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: azizt
  Date: 2/17/2022
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <style>
        #right { display:none; }
    </style>
</head>
<body class="bg-dark">
<div class="container">
    <div class="row vh-100 py-5 align-items-center justify-content-center">
        <div class="col-md-12 text-center text-white p-3 border border-white rounded-3">
            <h1 class="h1">Update Employee</h1>
            <p class="small text-white">Fill the form below to update an employee</p>
            <c:if test="${err != null}">
                <div class="alert alert-danger text-center">${err}</div>
            </c:if>
            <form action="${pageContext.request.contextPath}/employee/update" method="post">
                <input hidden name="id" value="${employee.getIdUser()}"/>
                <div class="row m-0">
                    <div class="form-group col-md-4 text-start mb-3">
                        <label class="form-label" for="first-name">First name:</label>
                        <input type="text" id="first-name" value="${employee.getFirstName()}" name="first_name" class="form-control" placeholder="First name...">
                    </div>
                    <div class="form-group col-md-4 text-start mb-3">
                        <label class="form-label" for="last-name">Last name:</label>
                        <input type="text" id="last-name" name="last_name" value="${employee.getLastName()}" class="form-control" placeholder="Last name...">
                    </div>
                    <div class="form-group col-md-4 text-start mb-3">
                        <label class="form-label" for="entry-date">entryDate:</label>
                        <input type="date" id="entry-date" name="entry_date" value="${employee.getEntryDate()}" class="form-control" placeholder="Entry date...">
                    </div>
                </div>
                <div class="row m-0 border border-white rounded-3 my-3">
                    <div class="form-group col-md-12 text-start mb-3">
                        <label class="form-label" for="address">Adress:</label>
                        <ul class="nav nav-tabs border-0 mb-2" id="myTab" role="tablist">
                            <li class="nav-item w-50" role="presentation">
                                <button class="btn btn-sm p-1 w-100 nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Select an address</button>
                            </li>
                            <li class="nav-item w-50" role="presentation">
                                <button class="btn btn-sm p-1 w-100 nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Add new Address</button>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <div class="row">
                                    <div class="form-group text-start col-md-12 mb-3">
                                        <label class="form-label" for="address">Select an Address:</label>
                                        <select name="address" id="address" class="form-control" placeholder="Email address...">
                                            <option selected disabled value="">Select Address</option>
                                            <c:forEach var="address" items="${addresses}">
                                                <c:choose>
                                                    <c:when test="${employee.getAddress().getIdAddress() == address.getIdAddress()}">
                                                        <option selected value="${address.getIdAddress()}" >${address.getStreet()} - ${address.getCity()} - ${address.getCountry()} - ${address.getPostalCode()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${address.getIdAddress()}" >${address.getStreet()} - ${address.getCity()} - ${address.getCountry()} - ${address.getPostalCode()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                <div class="row" id="new-address">
                                    <div class="form-group text-start col-md-3 mb-3">
                                        <label class="form-label" for="country">Country:</label>
                                        <input type="text" id="country" name="country" class="form-control" placeholder="Country...">
                                    </div>
                                    <div class="form-group text-start col-md-3 mb-3">
                                        <label class="form-label" for="city">City:</label>
                                        <input type="text" id="city" name="city" class="form-control" placeholder="City...">
                                    </div>
                                    <div class="form-group text-start col-md-3 mb-3">
                                        <label class="form-label" for="street">Street:</label>
                                        <input type="text" id="street" name="street" class="form-control" placeholder="Street...">
                                    </div>
                                    <div class="form-group text-start col-md-3 mb-3">
                                        <label class="form-label" for="postal-code">Postal code:</label>
                                        <input type="number" id="postal-code" name="postal_code" class="form-control" placeholder="Postal code...">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row m-0">
                    <div class="form-group col-md-6 text-start mb-3">
                        <label class="form-label" for="email">Email:</label>
                        <input type="email" id="email" value="${employee.getEmail()}"  name="email" class="form-control" placeholder="Email address...">
                    </div>
                    <div class="form-group col-md-6 text-start mb-3">
                        <label class="form-label" for="password">Password:</label>
                        <input type="password" id="password" value="${employee.getPassword()}"  name="password" class="form-control" placeholder="Password...">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary w-100 btn-lg">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
