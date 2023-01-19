package hello.servlet.web.servlet;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("MemberSaveServlet.service");
        //�޾ƿ���
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        //member Repository�� �����ϱ�
        Member member = new Member(username, age);
        memberRepository.save(member);

        //member�� ���
        System.out.println("member = " + member);
        //���� ��� ����
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //ȭ�鿡 html �Ẹ����
        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "����\n" +
                "<ul>\n" +
                " <li>id="+member.getId()+"</li>\n" +
                " <li>username="+member.getUsername()+"</li>\n" +
                " <li>age="+member.getAge()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">����</a>\n" +
                "</body>\n" +
                "</html>");
    }
}