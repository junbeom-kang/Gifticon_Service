package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Item;
import gifticon.giticonshop.exception.NotEnoughStockException;
import gifticon.giticonshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
@Transactional
class ItemServiceImplTest {
    @Autowired ItemServiceImpl itemService;
    @Test
    public void 저장테스트() throws Exception {
        //given
        Item item=makeItem();
        //when
        Long itemId = itemService.join(item);
        //then
        assertThat(itemService.findOne(itemId)).isEqualTo(item);
    }
    @Test
    public void 전체목록_불러오기() throws Exception {
        //given
        Item item=makeItem();
        Item item1=makeItem();
        Item item2=makeItem();
        //when
        itemService.join(item);
        itemService.join(item1);
        itemService.join(item2);
        //then
        assertThat(itemService.findAll().size()).isEqualTo(3);

    }
    @Test
    public void 업데이트확인() throws Exception {
        //given
        Item item=makeItem();
        //when
        Long itemId = itemService.join(item);
        itemService.updateItem(itemId,"헌책",100,1);
        //then
        assertThat(item.getName()).isEqualTo("헌책");
        System.out.println(itemService.findOne(itemId).toString());

    }
    @Test
    public void 재고부족_예외테스트() throws Exception {
        //given
        Item item=makeItem();

        //when
        NotEnoughStockException e = assertThrows(NotEnoughStockException.class, () -> item.minus(11));;

        //then
        assertThat(e.getMessage()).isEqualTo("재고가 부족합니다");
    }


    private Item makeItem() {
        Item item=new Item();
        item.setName("jpabook");
        item.setPrice(10000);
        item.setStock(10);
        return item;
    }
}