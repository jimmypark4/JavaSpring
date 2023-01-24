package hello.servlet.web.frontcontroller.v5.adapter;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    /**
     *
     * @param handler
     * @return v3�� �ν��Ͻ� �̸� 1, �ƴϸ� 0 ����
     */
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    /**
     * ������Ʈ�� ��Ʈ�ѷ� v3�� ĳ����(int to string ó��)
     * �ڵ� �� ����, paramMap���� �����ؼ� �ְ� ������ mv�� ��ȯ����
     * @param request
     * @param response
     * @param handler ����: ��Ʈ�ѷ�
     * @return
     */
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        return mv;
    }
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}