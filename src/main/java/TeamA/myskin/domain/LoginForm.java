package TeamA.myskin.domain;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


// 로그인에 필요한 정보는 ID/Password 만 필요하므로 별도의 LoginForm을 생성한다.
@Data
public class LoginForm {
    @NotEmpty(message = "아이디를 입력해 주세요.")
    private String loginId;
    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password;
}
