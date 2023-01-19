package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp); �� ����� ������Ͻ� �� localhost:8080 ���� �����غ��ðھ��?
        System.out.println("helloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        resp.setContentType("text/palin");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello " + username);
    }
}
