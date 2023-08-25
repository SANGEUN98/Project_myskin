package TeamA.myskin.web;

import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.member.Member;
import TeamA.myskin.repository.ItemSearchCond;
import TeamA.myskin.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ItemService itemService;

    @RequestMapping("/")
    public String home(HttpServletRequest request, @ModelAttribute("itemSearch") ItemSearchCond itemSearch, Model model){
//        return "redirect:/imsi";
//        return "index"; // 이게 기본
        List<Item> items = itemService.findItems(itemSearch);
        model.addAttribute("items", items);

        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("세션에 없음");
            return "/index";
        }
        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);

        //세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            System.out.println("세션에 데이터 없음");
            return "/index";
        }
        model.addAttribute("member", loginMember);
        return "/loginindex";
//        return "redirect:/index";
    }
//


//    // 데이터 불러와지는지 확인하려고 임의로 만든 페이지 연결
//    @GetMapping("/index") // 메인 리스트 페이지에서 리스트들 동적으로 불러오는거
//    public String index(@ModelAttribute("itemSearch") ItemSearchCond itemSearch, Model model){
//        List<Item> items = itemService.findItems(itemSearch);
//        model.addAttribute("items", items);
//        return "/index";
//    }

//    @GetMapping("/loginindex")
//    public String loginindex(@ModelAttribute("itemSearch") ItemSearchCond itemSearch, Model model){
//        List<Item> items = itemService.findItems(itemSearch);
//        model.addAttribute("items", items);
//        return "/loginindex";
//    }

}
