console.log("sds")

$(function () {
    let products;
    let cookieKey;
    function getShoppingCart() {

        // document.cookie


        cookieKey = $("#my-username").text() + 'mybookList';
        products = Cookies.get(cookieKey) == undefined ? [] : JSON.parse(Cookies.get(cookieKey));
        $("#shopping-cart-number").text(getCount());
    }


    $(".add-shopping").click((e) => {
        var myId = $(e.target).attr("my-id");
        let hasProduct = false;
        for (let product of products) {
            if (product.id == myId) {
                product.number = parseInt(product.number) + 1;
                hasProduct = true;
                break;
            }
        }
        if (!hasProduct) {
            products.push({
                id: myId,
                number: 1
            })
        }

        Cookies.set(cookieKey, JSON.stringify(products), {expires: 7});

        $("#shopping-cart-number").text(getCount());
        console.log(JSON.parse(Cookies.get(cookieKey)))
    });

    function getCount() {
        let count = 0;
        for (let product of products) {
            count += product.number;
        }
        console.log(count);
        return count;
    }

    getShoppingCart();

});