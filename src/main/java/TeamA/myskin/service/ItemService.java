package TeamA.myskin.service;

import TeamA.myskin.domain.Item;
import TeamA.myskin.repository.ItemSearchCond;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Optional<Item> findById(int pid);
    List<Item> findItems(ItemSearchCond itemSearch);
}
