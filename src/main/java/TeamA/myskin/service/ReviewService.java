package TeamA.myskin.service;

import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.Review;
import TeamA.myskin.repository.ItemSearchCond;
import TeamA.myskin.repository.ReviewSearchCond;

import java.util.List;
import java.util.Optional;

public interface ReviewService {


    Optional<Review> findById(int rid);
    //List<Item> findItems(ItemSearchCond itemSearch);
    List<Review> findReviews(int pid);
}
