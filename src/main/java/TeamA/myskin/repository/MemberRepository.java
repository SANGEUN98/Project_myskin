package TeamA.myskin.repository;

import TeamA.myskin.domain.member.Member;
import TeamA.myskin.mybatis.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //
    void update(Long id, MemberUpdateDto updateParam);
    //
    Optional<Member> findById(Long id);
//    List<Item> findAll(ItemSearchCond cond);

    public Optional<Member> findByLoginId(String loginId);
    public List<Member> findAll();
}
