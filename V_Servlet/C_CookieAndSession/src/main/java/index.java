import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        // 1.判断当前用户是否已经登录
        HttpSession session = req.getSession(false);
        if (session == null) {
            // 用户没有登录，重定向到 login.html
            resp.sendRedirect("login.html");
            return;
        }

        // 2.如果已经登录，则从 Session 中取出访问次数数据
        String username = (String) session.getAttribute("username");
        String countString = (String) session.getAttribute("loginCount");

        int loginCount = Integer.parseInt(countString);
        loginCount += 1;
        session.setAttribute("loginCount", loginCount + "");

        // 3.展示到页面上
        StringBuilder html = new StringBuilder();
        html.append(String.format("<h3>用户名：%s</h3>", username));
        html.append(String.format("<h3>登录次数：%d</h3>", loginCount));
        resp.getWriter().write(html.toString());

    }
}
