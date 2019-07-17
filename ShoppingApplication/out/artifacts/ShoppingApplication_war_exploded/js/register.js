$(function () {
    function getUserInfo() {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/ShoppingApplication/getUser",
            success: function (res) {
                console.log(res);
// #("")
                let data = JSON.parse(res);
                var element = "";
                for (let i = 0; i < data.length; i++) {

                    element += "<div class=\"my-item\">" +
                        "<p class=\"card-text\">Username:</p>" + data[i].username +
                        "</div>";

                }

                $(".list-group").append(element);


            },
            error: function () {
                alert("add failed!");
            }

        })

    }


    $("#add-user-button").click(function () {
        $("#userModalLong").modal('show')
    });
    getUserInfo();
    $("#sign-up").click(function () {

        let username = $("input[name='username']").val();

        let password = $("input[name='password']").val();

        let cpassword = $("input[name='cpassword']").val();

        if (username == "") {
            alert("Please input username");
            return;
        }

        if (password == "") {
            alert("Please input password");
            return;
        }

        if (cpassword == "") {
            alert("Please input confirm password");
            return;
        }

        if (cpassword != password) {
            alert("confirm password must equal password");
            return;
        }


        let data = {"username": username, "password": password};
        $.ajax({
            type: "post",
            url: "http://localhost:8080/ShoppingApplication/register",
            data: data,
            success: function (res) {
                let data = JSON.parse(res);

                if (data.status == "0") {
                    alert(data.message);
                } else {
                    let user = JSON.parse(data.user);
                    var element = "";
                    element += "<div class=\"my-item\">" +
                        "<p class=\"card-text\">Username:</p>" + user.username +
                        "</div>";

                    $(".list-group").append(element);
                }


            },
            error: function () {
                alert("add failed!");
            }

        })
    })

});