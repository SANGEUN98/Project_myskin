package TeamA.myskin.mybatis;
import lombok.Data;

import java.util.List;

@Data
public class MemberUpdateDto {
    private String loginId;  // 로그인 ID
    private String password;  // 로그인 Password
    private String name;  // 사용자(회원) 이름
    private String phoneNumber;  // 휴대폰 번호
    private String skin;  // 피부타입
    private String gender;  // 성별

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(String loginId, String password, String name, String phoneNumber, String skin, String gender) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skin = skin;
        this.gender = gender;
    }
}
