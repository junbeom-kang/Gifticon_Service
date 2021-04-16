package gifticon.giticonshop.repository;

import gifticon.giticonshop.domain.Gift;
import gifticon.giticonshop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class GiftRepositoryImpl implements GiftRepository{
    private final EntityManager em;
    private final MemberRepository memberRepository;
    @Override
    public void save(Gift gift) {
        em.persist(gift);
    }

    @Override
    public List<Gift> findByBuyer(Long id) {
        return em.createQuery("select g from Gift g where g.buyMember.id=:id", Gift.class).setParameter("id",id).getResultList();
    }

    @Override
    public List<Gift> findByGetter(Long id) {
        return em.createQuery("select g from Gift g where g.getMember.id=:id", Gift.class).setParameter("id",id).getResultList();

    }

    @Override
    public Gift findOne(Long id) {
        return em.find(Gift.class, id);
    }

    @Override
    public List<Gift> findAll() {
        return em.createQuery("select g from Gift g",Gift.class).getResultList();
    }
}
