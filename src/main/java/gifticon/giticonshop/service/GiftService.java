package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Gift;

import java.util.List;

public interface GiftService {
    Long make(Long buyerId,Long getterId,Long itemId,int count);
    List<Gift> gift_By_Buyer(Long id);
    List<Gift> gift_By_Getter(Long id);
    List<Gift> allGift();
}
