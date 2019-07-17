import dao.DataBase;
import model.AdminUser;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/adminLogin")
public class adminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/WEB-INF/view/adminLogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("admin");
        String password = req.getParameter("adminPwd");

        HashMap<String, AdminUser> adminUsers = DataBase.getDataBaseInstance().getAdminUsers();
        if (adminUsers.containsKey(username) && adminUsers.get(username).getAdminPwd().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("adminUser", adminUsers.get(username));

            resp.sendRedirect(req.getContextPath() + "/showAll");
        } else {
            resp.sendRedirect(req.getContextPath() + "/adminLogin");
        }
    }
}
