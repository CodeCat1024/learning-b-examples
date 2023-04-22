import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        // 1.获取用户信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.判断用户名和密码是否正确
        if (!username.equals("admin") || !password.equals("admin")) {
            resp.getWriter().write("登录失败！");
            return;
        }

        // 3.登录成功
        resp.getWriter().write("登录成功！");
        System.out.println("登录成功！");

        // 4.设置 Session
        HttpSession session = req.getSession(true);
        session.setAttribute("username", "admin");
        session.setAttribute("loginCount", "0");
        resp.sendRedirect("index");
    }
}
