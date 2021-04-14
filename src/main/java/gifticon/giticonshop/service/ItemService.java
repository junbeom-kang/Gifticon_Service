package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Item;

import java.util.List;

public interface ItemService {
    void join(Item item);

    List<Item> Items();

}
