<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 2019-07-10
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/showAll.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}\/js\/JQuery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}\/js\/showAll.js"></script>

    <title>Products</title>
</head>
<body>


<h1>Products List</h1>

<form class="form-inline my-2 my-lg-0" method="post">
        <button id="addBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Add Product</button>
</form>




    <div class="container">
        <div class="products">
            <ul class="list-group" id="my-group">


            </ul>
        </div>
    </div>

</body>
</html>
