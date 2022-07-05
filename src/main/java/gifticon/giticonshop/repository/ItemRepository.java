package gifticon.giticonshop.repository;

import gifticon.giticonshop.domain.Item;

import java.util.List;

public interface ItemRepository {
    //test
    void save(Item item);
    Item findOne(Long id);
    List<Item> findAll();
    List<Item> findByName(String name);
}
