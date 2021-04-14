package gifticon.giticonshop.repository;

import gifticon.giticonshop.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    EntityManager em;
    @Override
    public void save(Item item) {
        em.persist(item);
    }

    @Override
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("Select i from Item i", Item.class).getResultList();
    }

    @Override
    public List<Item> findByName(String name) {
        return em.createQuery("select i from Item i where i.name=:name").setParameter("name",name).getResultList();
    }
}
