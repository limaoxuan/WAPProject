$(function () {
    $("#add").click(function () {
        var dldata = {
            "productName": $("#product_name").val(),
            "productDes": $("#detail").val(),
            "price": $("#price").val(),
            "productUrl": $("#image_url").val()
        };

        var data = JSON.stringify(dldata);

        //alert(data);
        $.ajax({
            type:"post",
            url:"http://localhost:8080/ShoppingApplication/addProduct",
            data:{"datalist": data},
            // dataType:"json",
            success:function(data) {
                // console.log(data);
                // var res = JSON.parse(data);
                if(data.message = "success") {
                    window.location.href = "http://localhost:8080/ShoppingApplication/show";
                   // alert("add successful！");
                   // console.log(data);
                }
            },
            error:function(){
                alert("add failed!");
            }
        })
    });
})