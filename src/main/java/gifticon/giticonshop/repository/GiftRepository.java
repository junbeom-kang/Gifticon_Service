package gifticon.giticonshop.repository;

import gifticon.giticonshop.domain.Gift;

import java.util.List;

public interface GiftRepository {
    void save(Gift gift);
    List<Gift> findByBuyer(Long id);
    List<Gift> findByGetter(Long id);
    Gift findOne(Long id);
    List<Gift> findAll();

}
