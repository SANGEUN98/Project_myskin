package TeamA.myskin.mybatis;

import TeamA.myskin.domain.Review;
import TeamA.myskin.repository.ReviewRepository;
import TeamA.myskin.repository.ReviewSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisReviewRepository implements ReviewRepository{
    private final ReviewMapper reviewMapper;

    @Override
    public Optional<Review> findById(int rid) {
        return reviewMapper.findById(rid);
    }

//    @Override
//    public List<Item> findAll(ItemSearchCond cond) {
//        return itemMapper.findAll(cond);
//    }
    @Override
    public List<Review> findAll(int pid) {
        return reviewMapper.findAll(pid);
    }
}
