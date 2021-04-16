package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Gift;
import gifticon.giticonshop.domain.Item;
import gifticon.giticonshop.domain.Member;
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
    @Rollback(false)
    public void Gift_DB_테스트() throws Exception {
        //given
        Long b,g,i;
        Long[] work = work();
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
    public void 구매자로_검색() throws Exception {
        //given
        Long b,g,i;
        Long[] work = work();
        b=work[0];
        g=work[1];
        i=work[2];
        Long giftId=giftService.make(b,g,i,4);
        //when
        //then
        System.out.println(giftService.findOne(giftId));
        em.flush();
        List<Gift> gifts = giftService.gift_By_Getter(b);
        System.out.println(b);
        System.out.println("==================");
        for (Gift x : gifts) {
            System.out.println(x);
        }
        System.out.println("==================");


    }
    Long[] work() {
        Member member=new Member();
        member.setName("준범");
        memberService.join(member);
        Member member1=new Member();
        member1.setName("창훈");
        memberService.join(member1);
        Item item=new Item();
        item.setName("핸드폰");
        itemService.join(item);
        return new Long[]{member.getId(),member1.getId(),item.getId()};

    }
}