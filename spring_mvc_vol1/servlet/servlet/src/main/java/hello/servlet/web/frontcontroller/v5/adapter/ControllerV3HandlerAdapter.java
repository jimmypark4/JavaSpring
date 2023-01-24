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
     * @return v3의 인스턴스 이면 1, 아니면 0 리턴
     */
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    /**
     * 오브젝트를 컨트롤러 v3로 캐스팅(int to string 처럼)
     * 핸들 할 로직, paramMap으로 매핑해서 넣고 돌려서 mv로 반환받음
     * @param request
     * @param response
     * @param handler 옵젝: 컨트롤러
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