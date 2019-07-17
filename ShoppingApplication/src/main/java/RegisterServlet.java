import com.google.gson.Gson;
import dao.DataBase;
import model.Product;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private Gson gson = new Gson();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/register.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       String password = req.getParameter("password");

        HashMap<String, String> map = new HashMap<>();

        PrintWriter out = resp.getWriter();

        if (DataBase.getDataBaseInstance().getUsers().containsKey(username)) {
            map.put("status","0");
            map.put("message","username is exist");
//            map.put("message","username is exist");
        } else {
            DataBase.getDataBaseInstance().addUser(username, password);
            User user = DataBase.getDataBaseInstance().getUsers().get(username);



//            Gson gson = new Gson();
//            String productJason = gson.toJson(user);
            map.put("status","1");
            map.put("message","add success");
            map.put("user",gson.toJson(user));

        }

        out.write(gson.toJson(map));



//        PrintWriter out = resp.getWriter();




//
//
//
//
//        resp.getWriter().write(gson.toJson(map));


    }
}
