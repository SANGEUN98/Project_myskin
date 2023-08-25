package TeamA.myskin.repository;

import lombok.Data;

@Data
public class MemberUpdateDto {
    private String password;
    private String password2;
    private String email;
    private String phoneNumber;

    public MemberUpdateDto(){
    }

    public MemberUpdateDto(String password, String password2, String email, String phoneNumber) {
        this.password = password;
        this.password2 = password2;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
