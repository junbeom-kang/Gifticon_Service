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
    private final ItemRepository itemRepository;
    @Override
    @Transactional
    public Long join(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    @Override
    public List<Item> Items() {
        return itemRepository.findAll();
    }

    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
    public List<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }
    @Transactional
    public void updateItem(Long id,String name,Long price,Long count) {
        Item find = itemRepository.findOne(id);
        find.setName(name);
        find.setPrice(price);
        find.setStock(count);
    }

}
