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
    <script type="text/javascript" src="${pageContext.request.contextPath}\/js\/JQuery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}\/js\/add.js"></script>

    <title>Add Product</title>
</head>
<body>
<%--<form id ="addFrom" method="post">--%>
    <div class="container my-container">
        <div class="content">
            <h1>Add Product</h1>
            <div class="form-group">
                <label>Product name :</label>
                <input type="text" class="form-control" id="product_name" name="productName" placeholder="product name">
            </div>
            <div>
                <label>Details : </label>
                <input type="text" class="form-control" id="detail" name="productDetails" placeholder="details">
            </div>
            <div>
                <label>Price : </label>
                <input type="number" class="form-control" id="price" name="productPrice" placeholder="Price">
            </div>
            <div>
                <label>Image URL : </label>
                <input type="text" class="form-control" id="image_url" name="productImage" placeholder="image">
            </div>
            <input type="submit" id="add" class="btn btn-primary" value="Add"/>
            <div>${error}</div>
        </div>


    </div>

<%--</form>--%>
</body>
</html>