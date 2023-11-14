package httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 每秒钟刷新一次，并显示当前时间戳
 */
@WebServlet("/autoRefresh")
public class B_AutoRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Refresh", "1");

        long timeStamp = new Date().getTime();
        resp.getWriter().write("timeStamp = " + timeStamp);
    }
}
