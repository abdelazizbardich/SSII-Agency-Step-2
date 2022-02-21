<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Admin login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="bg-dark">
<div class="container">
    <div class="row vh-100 py-5 align-items-center justify-content-center">
        <div class="col-md-6 text-center text-white p-3 border border-white rounded-3">
            <h1 class="h1">Admin login</h1>
            <p class="small text-white">Please login to get access to your admin area</p>
            <c:if test="${empty err}">
                <div class="alert alert-danger text-center">${err}</div>
            </c:if>
            <form action="${pageContext.request.contextPath}/admin/login" method="post">
                <div class="form-group text-start mb-3">
                    <label class="form-label" for="email">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Email address...">
                </div>
                <div class="form-group text-start mb-3">
                    <label class="form-label" for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password...">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary w-100 btn-lg">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
