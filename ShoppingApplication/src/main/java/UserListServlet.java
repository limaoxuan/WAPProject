import com.google.gson.Gson;
import dao.DataBase;
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

@WebServlet("/getUser")
public class UserListServlet extends HttpServlet {


    private Gson gson = new Gson();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Collection<User> values = DataBase.getDataBaseInstance().getUsers().values();

        Gson gson = new Gson();
        String productJason = gson.toJson(values);

        out.write(productJason);
    }
}
