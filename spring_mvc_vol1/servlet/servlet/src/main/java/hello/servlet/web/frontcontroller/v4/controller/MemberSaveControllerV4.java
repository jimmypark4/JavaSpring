package hello.servlet.web.frontcontroller.v4.controller;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import java.util.Map;
public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
      //paramMap에서 값 꺼내주고
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
      //비즈니스 로직 실행 : member에 이름 나이 저장후 repo에 저장
        Member member = new Member(username, age);
        memberRepository.save(member);
      //모델 에 member 객체 넣어주고 , 논리주소 값만 리턴
        model.put("member", member);
        return "save-result";
    }
}