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
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//persist 전파를 위한 cascade
    @JoinColumn(name="member_id")
    private Member buyMember;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//n+1 쿼리 문제를 막기위한 fetch lazy
    @JoinColumn(name="member_id")
    private Member getMember;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;
    private String giftCode;

    private String orderDate;

    private Long count;
    private Used Use;
    //연관관계 편의 메서드
    //연관관계의 주인은 Gift
    public void setMember(Member buyMember,Member getMember) {
        this.buyMember=buyMember;
        this.getMember=getMember;
        buyMember.getSend_Gifts().add(this);
        getMember.getGifts().add(this);
    }
}
