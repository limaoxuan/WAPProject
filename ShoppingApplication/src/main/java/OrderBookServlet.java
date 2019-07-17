import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dao.DataBase;
import model.BookBeanHelp;
import model.BookingList;
import model.Product;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet("/orderBooks")
public class OrderBookServlet extends HttpServlet {
    private Gson gson = new Gson();
    private JsonParser parser = new JsonParser();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        String shopping = URLDecoder.decode(Arrays.stream(req.getCookies())
                .filter(x -> x.getName().equals(user.getUsername() + "myOrderBookList"))
                .map(x -> x.getValue()).collect(Collectors.joining("")), "UTF-8");

        if (shopping.equals("")) {
            req.setAttribute("bookingList", new ArrayList<>());
            req.setAttribute("totalPrice", 0);

            req.getRequestDispatcher("/WEB-INF/view/OrderBook.jsp").forward(req, resp);
        }


        JsonArray jsonArray = parser.parse(shopping).getAsJsonArray();
        ArrayList<Product> products = DataBase.getDataBaseInstance().getProducts();
        ArrayList<BookingList> res = new ArrayList<>();
        double totalPrice = 0;
        for (JsonElement obj : jsonArray) {
            BookBeanHelp bookBeanHelp = gson.fromJson(obj, BookBeanHelp.class);

//            System.out.println(bookBeanHelp);


            boolean present = products.stream().filter(x -> x.getId().equals(bookBeanHelp.getId())).findFirst().isPresent();

            if (present) {
                Product product = products.stream().filter(x -> x.getId().equals(bookBeanHelp.getId())).findFirst().get();
                ;
                BookingList shoppingCart = new BookingList(product, bookBeanHelp.getNumber());

                totalPrice += shoppingCart.getProduct().getPrice() * shoppingCart.getNumber();
                res.add(shoppingCart);
            }

        }

        req.setAttribute("bookingList", res);
        req.setAttribute("totalPrice", Float.parseFloat(String.format("%.2f", totalPrice)));

        req.getRequestDispatcher("/WEB-INF/view/OrderBook.jsp").forward(req, resp);
    }
}
