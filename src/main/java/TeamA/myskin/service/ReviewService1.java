package TeamA.myskin.service;


import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.Review;

import TeamA.myskin.repository.ItemSearchCond;
import TeamA.myskin.repository.ReviewRepository;
import TeamA.myskin.repository.ReviewSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService1 implements ReviewService{

    //    private final ItemRepository memRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findById(int rid) {
        return reviewRepository.findById(rid);
    }
//    @Override
//    public List<Item> findItems(ItemSearchCond cond) {
//        return itemRepository.findAll(cond);
//
//    }
    @Override
    public List<Review> findReviews(int pid) {
        return reviewRepository.findAll(pid);

    }


}
