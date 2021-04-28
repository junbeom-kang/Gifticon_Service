package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Gift;
import gifticon.giticonshop.domain.Item;
import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.exception.NotEnoughStockException;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static gifticon.giticonshop.domain.Gift.createGift;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
class GiftServiceImplTest {
    @Autowired
    GiftServiceImpl giftService;
    @Autowired MemberService memberService;
    @Autowired ItemServiceImpl itemService;
    @PersistenceContext
    EntityManager em;


    @Test
    public void Gift_DB_테스트() throws Exception {
        //given
        Long b,g,i;
        Long[] work = work("준범","창훈","핸드폰");
        b=work[0];
        g=work[1];
        i=work[2];

        Long giftId=giftService.make(b,g,i,4);
        //when
        Gift findGift = giftService.findOne(giftId);
        System.out.println(findGift);
        //then
        assertThat(findGift.getId()).isEqualTo(giftId);
        //member도 item도 모두 persist해야될 것이라는 생각이 들었었는데 생각해보니까 cacadeType All로 처리했었다.
    }
    @Test
    public void 구매자별_판매자별로_검색() throws Exception {
        //given
        Long[] work = work("준범","창훈","핸드폰");
        Long giftId=giftService.make(work[0],work[1],work[2],4);
        Long[] work1 = work("준범","정엽","책");
        Long giftId1=giftService.make(work[0],work1[1],work1[2],5);

        //when
        List<Gift> buyer_gifts = giftService.find_By_Buyer(work[0]);
        List<Gift> getter_gifts = giftService.find_By_Getter(work[1]);
        //then
        System.out.println("==================");
        for (Gift x : buyer_gifts) {
            System.out.println(x);
        }
        System.out.println("==================");
        System.out.println("==================");
        for (Gift x : getter_gifts) {
            System.out.println(x);
        }
        System.out.println("==================");
        assertThat(buyer_gifts.size()).isEqualTo(2);
        assertThat(getter_gifts.size()).isEqualTo(1);
    }
    @Test
    public void Gift_생성시_재고부족_테스트() throws Exception {
        //given
        Long b,g,i;
        Long[] work = work("준범","창훈","핸드폰");
        b=work[0];
        g=work[1];
        i=work[2];
        //when
        NotEnoughStockException e=assertThrows(NotEnoughStockException.class,()->giftService.make(b,g,i,100));
        //then
        assertThat(e.getMessage()).isEqualTo("재고가 부족합니다");
    }

    Long[] work(String buy,String get,String itemName) {
        Member member=new Member();
        member.setName(buy);
        memberService.join(member);
        Member member1=new Member();
        member1.setName(get);
        memberService.join(member1);
        Item item=new Item();
        item.setName(itemName);
        item.setStock(5);
        itemService.join(item);
        return new Long[]{member.getId(),member1.getId(),item.getId()};

    }
}