package TeamA.myskin.web.login;


import TeamA.myskin.domain.LoginForm;
import TeamA.myskin.domain.member.Member;
import TeamA.myskin.service.MemberService;
import TeamA.myskin.web.SessionConst;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
//@RequestMapping("/form")
public class LoginController {

    //    private final LoginService loginService;
    private final MemberService memberService;


    @GetMapping("/form/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        System.out.println("LoginController.loginForm");
        return "/form/login/loginForm";
    }
    //
//    //    @PostMapping("/login")
//    // HttpServletResponse: 로그인 요청에 대한 쿠키 응답을 만들기 위해 사용
//    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response) {
//        if (bindingResult.hasErrors()) {
//            return "/form/login/loginForm";
//        }
//
//        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
//
//        if (loginMember == null) {
//            // reject() 전역오류에 에러 메세지 추가
//            // 추가된 내용은 View Template(Thymeleaf에 전달)
//            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
//            return "form/login/loginForm";
//        }
//
//        //로그인 성공 처리
//
//        //쿠키에 시간 정보를 주지 않으면 세션 쿠키(브라우저 종료시 모두 종료)
////        로그인에 성공하면 쿠키를 생성하고 HttpServletResponse 에 담는다. 쿠키 이름은 memberId 이고, 값은
////        회원의 id 를 담아둔다. 웹 브라우저는 종료 전까지 회원의 id 를 서버에 계속 보내줄 것이다.
//        Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
//        response.addCookie(idCookie);
//        return "redirect:/";
//
//    }
    @PostMapping("/form/login")
    public String loginV3(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
//        int result = 10 / 0 ;  // 강제 예외 발생 샘플
        if (bindingResult.hasErrors()) {
            return "form/login/loginForm";
        }

        Member loginMember = memberService.login(form.getLoginId(), form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "form/login/loginForm";
        }

        //로그인 성공 처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성 (기본 인자값이 true임)
        // session id는 getSession 메소드에서 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";

    }

    //        @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        expireCookie(response, "memberId");
        return "redirect:/";
    }
    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest request) {
// HttpSerletRequest 객체는 각각의 클라이언트 요청마다 새로운 인스턴스가 생성
// 따라서 특정 클라이언트의 세션을 가져온다.
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 가져온 세션을 무효화한다.
            session.invalidate();
        }
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        // 서버에서 해당 쿠키의 종료 날짜를 0으로 지정 => 쿠키 종료를 의미함
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
