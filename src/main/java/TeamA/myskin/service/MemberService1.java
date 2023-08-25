package TeamA.myskin.service;

import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.member.Member;
import TeamA.myskin.mybatis.MemberUpdateDto;
import TeamA.myskin.repository.ItemRepository;
import TeamA.myskin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService1 implements MemberService{

    //    private final ItemRepository memRepository;
    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);

//        if(memberRepository.findById(member.getId()).isEmpty()){
//            return memberRepository.save(member);
//        }
//        else return null;
    }

    @Override
    public void update(Long id, MemberUpdateDto updateParam) {
        memberRepository.update(id, updateParam);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId)
//                passwordd와 일치하면 해당 객체를 반환
                .filter(m -> m.getPassword().equals(password))
//                password와 일치하지 않으면 null을 반환
                .orElse(null);
//        return null;
    }


}
