package TeamA.myskin.mybatis;

import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.Review;
import TeamA.myskin.repository.ReviewSearchCond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReviewMapper {
//    void save(Item item);
//
//    // MyBatis는 위치 기반으로 파마레터를 매핑하기 때문에 파라메터가 2개 이상일 떄에는 @Param을 지정해야 한다.
//    // 2개 이상일 때 @Param 어노테이션을 지정하는 것은 스프링에서의 룰
//    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);
////    void update(Long id, ItemUpdateDto updateParam);

    Optional<Review> findById(int rid);

//    List<Item> findAll(ItemSearchCond itemSearch);
    //
    List<Review> findAll(int pid);
}
