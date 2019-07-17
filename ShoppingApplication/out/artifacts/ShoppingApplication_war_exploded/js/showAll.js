$(function () {
    $.ajax({
        type:"post",
        url:"http://localhost:8080/ShoppingApplication/show",
        // data:{"products": data},
        dataType:"json",
        success:function(data) {
            // alert(data.length);

            let str = "";
            $.each(data, function(i, p){

                str +=
                    "                    <div class=\"my-item\">\n" +
                    "                        <span hidden>" + p.id + "</span>\n" +
                    "                        <img src="+p.productUrl +"\n" +
                    "                         class=\"img-thumbnail rounded float-left my-img\" alt="+p.productName+">\n" +
                    "                        <div class=\"right-side\">\n" +
                    "                            <h5 class=\"card-title\">"+p.productName +"</h5>\n" +
                    "                            <p class=\"card-text\">"+ p.productDes +"</p>\n" +
                    "                            <p class=\"card-text\">"+p.price+"</p>\n" +
                    "                        </div>\n" +
                    "        </div>";

            });


            $("#my-group").append(str);
           // alert("products update successful！");

        },
        error:function(){
            alert("show products failed!");
        }
    })
})