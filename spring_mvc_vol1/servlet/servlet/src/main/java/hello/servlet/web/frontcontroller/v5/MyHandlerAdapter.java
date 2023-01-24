package hello.servlet.web.frontcontroller.v5;
import hello.servlet.web.frontcontroller.ModelView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ��Ϳ� �������̽�
 * ����ʹ� ���� ��Ʈ�ѷ��� ȣ���ϰ�, �� ����� ModelView�� ��ȯ�ؾ� �Ѵ�.
 * ���� ��Ʈ�ѷ��� ModelView�� ��ȯ���� ���ϸ�, ����Ͱ� ModelView�� ���� �����ؼ��󵵹�ȯ�ؾ� �Ѵ�.
 * �������� ����Ʈ ��Ʈ�ѷ��� ���� ��Ʈ�ѷ��� ȣ�������� ������ �� ����͸� ���ؼ� ���� ��Ʈ�ѷ��� ȣ��ȴ�
 */
public interface MyHandlerAdapter {
    boolean supports(Object handler); //handler�� ��Ʈ�ѷ��� ����,��Ͱ� �ش� ��Ʈ�ѷ� ó�� ���� �Ǵ���.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
