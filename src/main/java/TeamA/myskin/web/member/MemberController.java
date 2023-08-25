package TeamA.myskin.web.member;

import TeamA.myskin.domain.member.Member;
import TeamA.myskin.repository.MemberRepository;
import TeamA.myskin.service.MemberService;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/form/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new Member());
        return "/form/members/createMember";
    }

    @PostMapping("/join")
    public String join(@Validated Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){ //hasError() 유효성 오류가 발생한 경우 true 리턴
            // 유효성 오류가 발생한 경우 저장을 하지 않고 다시 입력폼으로 forwarding
            return "/form/members/createMember";
        }
//        memberService.save(member);
//        return "redirect:/";

        Member saveMember = memberService.save(member);
        if(saveMember == null) {
            bindingResult.rejectValue("saveFail", "savFail", "중복되는 아이디가 있습니다!");
            return "/form/members/createMember";
        }
        return "redirect:/";
    }

    //    @ModelAttribute("skin")
    public Map<String, String> skin() {
/*
  HashMap - LinkedHashMap - ArrayList
* HashMap: 값을 Key, Value로 저장, 순서는 보장하지 않는다.
* LinkedHashMap: 값을 Key, Value로 저장, 저장 시 순서대로 저장,(순서 보장)
                저장 자료구조가 Linked List를 사용
* ArrayList: 데이터만 순서대로 저장
*/
        Map<String, String> skin = new LinkedHashMap<>();
        skin.put("DRY", "건성");
        skin.put("NORMAL", "중성");
        skin.put("OILY", "지성");
        return skin;


    }

    //    @ModelAttribute("gender")
    public Map<String, String> gender() {
/*
  HashMap - LinkedHashMap - ArrayList
* HashMap: 값을 Key, Value로 저장, 순서는 보장하지 않는다.
* LinkedHashMap: 값을 Key, Value로 저장, 저장 시 순서대로 저장,(순서 보장)
                저장 자료구조가 Linked List를 사용
* ArrayList: 데이터만 순서대로 저장
*/
        Map<String, String> gender = new LinkedHashMap<>();
        gender.put("MALE", "남성");
        gender.put("FEMALE", "여성");
        return gender;


    }

    //    라디오 박스용
//    @ModelAttribute("gender")
//    public Gender[] gender() {
//        return Gender.values();
//    }
}
