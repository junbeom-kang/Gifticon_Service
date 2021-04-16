package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Gift;
import gifticon.giticonshop.domain.Item;
import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.repository.GiftRepository;
import gifticon.giticonshop.repository.GiftRepositoryImpl;
import gifticon.giticonshop.repository.ItemRepositoryImpl;
import gifticon.giticonshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class GiftServiceImpl implements GiftService {
    private final GiftRepositoryImpl giftRepository;
    private final ItemRepositoryImpl itemRepository;
    private final MemberRepository memberRepository;
    @Override
    public Long make(Long buyerId,Long getterId,Long itemId,int count) {
        Member buyer=memberRepository.findOne(buyerId);
        Member getter = memberRepository.findOne(getterId);
        Item item = itemRepository.findOne(itemId);
        Gift gift = Gift.createGift(buyer, getter, item, count);
        giftRepository.save(gift);
        return gift.getId();
    }

    @Override
    public List<Gift> gift_By_Buyer(Long id) {
        return giftRepository.findByBuyer(id);
    }

    @Override
    public List<Gift> gift_By_Getter(Long id) {
        return giftRepository.findByGetter(id);
    }

    @Override
    public List<Gift> allGift() {
        return giftRepository.findAll();
    }

    public Gift findOne(Long id) {
        return giftRepository.findOne(id);
    }
}
