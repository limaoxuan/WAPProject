<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 2019-07-10
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminLogin.css">
    <meta charset="UTF-8">
    <title>Admin Login Page</title>
</head>
<body>
<form action="adminLogin" method="post">
    <div class="container my-container">
        <div class="content">
            <div class="form-group">
                <h1>Admin Login</h1>
                <label for="username">Username :</label>
                <input type="text" class="form-control" id="username" name="admin" placeholder="username">
            </div>
            <div>
                <label for="password">Password : </label>
                <input type="password" class="form-control" id="password" name="adminPwd" placeholder="password">
            </div>
            <input type="submit" class="btn btn-primary" value="login"/>
            <div>${error}</div>
        </div>


    </div>

</form>
</body>
</html>