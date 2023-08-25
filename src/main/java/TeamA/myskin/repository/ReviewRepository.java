package TeamA.myskin.repository;


import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
//    Item save(Item item);
//
//    void update(Long itemId, ItemUpdateDto updateParam);
//
    Optional<Review> findById(int rid);
//    List<Item> findAll(ItemSearchCond cond);

    List<Review> findAll(int pid);
}
