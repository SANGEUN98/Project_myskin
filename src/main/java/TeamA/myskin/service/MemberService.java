package TeamA.myskin.service;

import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.member.Member;
import TeamA.myskin.mybatis.MemberUpdateDto;

import java.util.Optional;

public interface MemberService {

    Member save(Member member);

    void update(Long id, MemberUpdateDto updateParam);

    Optional<Member> findById(Long id);

    Member login(String loginId, String password);
}
