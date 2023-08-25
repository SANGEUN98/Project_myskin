package TeamA.myskin.mybatis;

import TeamA.myskin.domain.member.Member;
import TeamA.myskin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {
    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        memberMapper.save(member);
        return member;
    }

    @Override
    public void update(Long Id, MemberUpdateDto updateParam) {
        memberMapper.update(Id, updateParam);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberMapper.findById(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);

//        System.out.println("마이바티스맴버 레포지토리: 파인드바이로긴아디 실행");
//        return findAll().stream()
//                .filter(m -> m.getLoginId().equals(loginId))
//                .findFirst();
    }

    @Override
    public List<Member> findAll() {
        System.out.println("마이바티스맴버 레포지토리: 파인드올 실행");
        return memberMapper.findAll();
//        return new ArrayList<>(store.values());
    }
}
