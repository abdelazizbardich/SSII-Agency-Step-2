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
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="bg-dark">
  <div class="container">
      <div class="row vh-100 py-5 align-items-center justify-content-center">
            <div class="col-md-6 text-center text-white p-3 border border-white rounded-3">
                <h1 class="h1">Welcom to Employee Management Sys</h1>
                <p class="small text-white">Fell free to login if you have admin access</p>
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/admin/login">Login</a>
            </div>
      </div>
  </div>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
