<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 2019-07-15
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"
          ></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/register.js"></script>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <div class="container ">

        <div class="products">
            <ul class="list-group">


            </ul>
            <button  id="add-user-button" class="btn btn-primary" >Add User</button>
            <a href="${pageContext.request.contextPath}/login" id="ad" class="btn btn-primary" >Login</a>
        </div>



        <!-- Modal -->



    </div>

    <div class="modal fade" id="userModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="username">Username :</label>
                        <input type="text" class="form-control" id="username" name="username" value="${cookie.username.value}"
                               placeholder="username">
                    </div>
                    <div>
                        <label for="password">Password : </label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="password">
                    </div>

                    <div>
                        <label for="password">Confirm Password : </label>
                        <input type="password" class="form-control" id="cpassword" name="cpassword" placeholder="password">
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button id="sign-up" type="button" class="btn btn-primary">sign up</button>
                </div>
            </div>
        </div>
    </div>



</body>
</html>
