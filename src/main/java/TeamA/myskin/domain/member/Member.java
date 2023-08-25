package TeamA.myskin.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class Member {
    private Long id;  // 레코드 ID (중복 ID, 중복 Password 가능)

    @NotEmpty(message = "아이디를 입력해 주세요.")
    private String loginId;  // 로그인 ID
    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password;  // 로그인 Password
    @NotEmpty(message = "이름을 입력해 주세요.")
    private String name;  // 사용자(회원) 이름
    private String phoneNumber;  // 휴대폰 번호
    private String skin;  // 피부타입
    private String gender;  // 성별

    public Member() {
    }

//    public Member(String loginId, String password, String name) {
//        this.loginId = loginId;
//        this.password = password;
//        this.name = name;
//    }

    public Member(Long id, String loginId, String password, String name, String phoneNumber, String skin, String gender) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skin = skin;
        this.gender = gender;
    }
}