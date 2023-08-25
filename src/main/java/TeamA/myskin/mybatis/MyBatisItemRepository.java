package TeamA.myskin.mybatis;

import TeamA.myskin.domain.Item;
import TeamA.myskin.repository.ItemRepository;
import TeamA.myskin.repository.ItemSearchCond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class MyBatisItemRepository implements ItemRepository {
    private final ItemMapper itemMapper;
    @Override
    public Optional<Item> findById(int pid) {
        return itemMapper.findById(pid);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        return itemMapper.findAll(cond);
    }
}
