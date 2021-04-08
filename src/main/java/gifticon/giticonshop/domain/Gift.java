package gifticon.giticonshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter @Setter
public class Gift {
    @Id @GeneratedValue
    @Column(name="gift_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;
    private String giftCode;

    private String orderDate;

    private Long count;
    private Used Use;
    /*
    public Gift createGift(Member member,Long count) {
        Gift gift = new Gift();
        gift.set
    }
     */
}
