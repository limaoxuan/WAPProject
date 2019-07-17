import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dao.DataBase;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
        req.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(req, resp);
 //         req.getRequestDispatcher("/WEB-INF/view/productList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        String product = req.getParameter("datalist");
        System.out.println(product);

        Gson gson = new Gson();
        Product product1 = gson.fromJson(product, Product.class);
        DataBase.getDataBaseInstance().addProduct(product1);

        HashMap<String,String> map = new HashMap<>();
        map.put("message","success");
        PrintWriter out = resp.getWriter();
        out.write(gson.toJson(map));



//      //  List<Product> products = new ArrayList<>();
//        JsonParser parser = new JsonParser();
//
//        JsonArray jarray = parser.parse(product).getAsJsonArray();
//
//        for (JsonElement jsonElement : jarray) {
//          //  products.add(gson.fromJson(jsonElement, Product.class));
//          //  System.out.println(products.toString());
//            DataBase.getDataBaseInstance().addProduct(gson.fromJson(jsonElement, Product.class));
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/products.jsp");


    }
}
