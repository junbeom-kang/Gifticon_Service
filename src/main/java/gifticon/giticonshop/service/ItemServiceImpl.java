package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Item;
import gifticon.giticonshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService{
    ItemRepository itemRepository;
    @Override
    @Transactional(readOnly = true)
    public void join(Item item) {
        Item find = itemRepository.findOne(item.getId());
        if (find== null) {
            itemRepository.save(item);
        } else {
            find.setStock(item.getStock()+find.getStock());
        }
    }

    @Override
    public List<Item> Items() {
        return itemRepository.findAll();
    }
}
