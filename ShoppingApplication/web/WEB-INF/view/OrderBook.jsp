<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 2019-07-16
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bookingList.css">
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <title>Order Books</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Books</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <a class="btn btn-outline-info my-3 my-sm-0" href="${pageContext.request.contextPath}/main">Books</a>
            <span style="margin-left: 10px; margin-right: 10px"></span>
            <form action="${pageContext.request.contextPath}/bookList" method="get">

                <button class="btn btn-info my-3 my-sm-0" type="submit">My Book Shopping Cart List  <span class="badge badge-light" id="shopping-cart-number"></span>
                    <span class="sr-only">unread messages</span>
                </button>
            </form>

        </ul>
        <form action="${pageContext.request.contextPath}/main" class="form-inline my-2 my-lg-0" method="post">
            <c:if test="${user != null}">
                <a class="nav-link" href="#">Hello ${user.username} <span class="sr-only"></span></a>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
            </c:if>
            <c:if test="${user == null}">
                <a class="nav-link" href="#">Hello Guest<span class="sr-only"></span></a>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-success my-2 my-sm-0"
                   type="submit">Login</a>
            </c:if>

        </form>
    </div>
</nav>
<div class="container">
    <div class="shopping-list">
        <span id="my-username" hidden>${user.username}</span>
        <ul class="list-group">
            <c:forEach items="${bookingList}" var="bookItem">
                <div class="my-item">
                    <span hidden>${bookItem.product.id}</span>
                    <img src="${bookItem.product.productUrl}"
                         class="img-thumbnail rounded float-left my-img" alt="${bookItem.product.productName}">
                    <div class="right-side">
                        <h5 class="card-title">${bookItem.product.productName}</h5>
                        <p class="card-text">${bookItem.product.productDes}</p>
                        <p class="card-text">Per Price :${bookItem.product.price}</p>
                        <p class="card-text">
                            <label >Number:</label>
                                ${bookItem.number}
                        </p>
                        <p class="card-text">Total:$${bookItem.number * bookItem.product.price}</p>

                    </div>
                </div>
            </c:forEach>
        </ul>
    </div>

    <div>
        <c:if test="${totalPrice  != 0}">

            <div class="alert alert-success" role="alert">
                <span>Total: ${totalPrice}</span>
            </div>
        </c:if>
        <c:if test="${totalPrice == 0}">

            <div class="alert alert-primary" role="alert">
                <span>It's empty</span>
            </div>


        </c:if>
    </div>




</div>








</body>
</html>
