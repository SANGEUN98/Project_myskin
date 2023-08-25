package TeamA.myskin.service;

import TeamA.myskin.domain.Item;
import TeamA.myskin.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import TeamA.myskin.repository.ItemSearchCond;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService1 implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Optional<Item> findById(int pid) {
        return itemRepository.findById(pid);
    }

    @Override
    public List<Item> findItems(ItemSearchCond cond) {
        return itemRepository.findAll(cond);

    }
}