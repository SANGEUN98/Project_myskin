package TeamA.myskin.repository;

import TeamA.myskin.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    //    Item save(Item item);
//
//    void update(Long itemId, ItemUpdateDto updateParam);
//
    Optional<Item> findById(int pid);
    List<Item> findAll(ItemSearchCond cond);
}
