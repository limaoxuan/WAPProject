$(function () {


    let cookieKey;
    let products;

    function getShoppingCart() {

        // document.cookie
        cookieKey = $("#my-username").text() + 'mybookList';
        products = Cookies.get(cookieKey) == undefined ? [] : JSON.parse(Cookies.get(cookieKey));

    }


    $("#checkout").click((e) => {

        $("#checkOutModalLong").modal('show')
    })

    $("#final-checkout").click((e) => {
        let myOrderBookListKey = $("#my-username").text() + 'myOrderBookList';

        let myOrderBookList = Cookies.get(myOrderBookListKey) == undefined ? [] : JSON.parse(Cookies.get(myOrderBookListKey));

        let newData = myOrderBookList.concat(products);

        Cookies.set(myOrderBookListKey, JSON.stringify(newData), {expires: 7});

        Cookies.set(cookieKey, JSON.stringify([]), {expires: 7});
        $('#checkOutModalLong').modal('hide');

        location.reload();
    })

    getShoppingCart();


});