package hello.servlet.web.springmvc.v3;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    //GetMapping 어노테이션은 다음과 같다.
    //@RequestMapping(value = "/new-from",method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form"; //그냥 문자만 반환해도됨
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,//파라미터 값 받아오기
            @RequestParam("age") int age, //22
            Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}