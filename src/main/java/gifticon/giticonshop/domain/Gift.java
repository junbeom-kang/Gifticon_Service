package gifticon.giticonshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter @Setter
public class Gift {
    @Id @GeneratedValue
    @Column(name="gift_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//persist 전파를 위한 cascade
    @JoinColumn(name="member_id",insertable = false, updatable = false)
    private Member buyMember;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//persist 전파를 위한 cascade
    @JoinColumn(name="member_id")
    private Member getMember;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;
    private String giftCode;

    private LocalDateTime orderDate;

    private Long count;
    @Enumerated(EnumType.STRING)
    private Used Use;
    //연관관계 편의 메서드
    //연관관계의 주인은 Gift
    /*
    public void setMember(Member buyMember,Member getMember) {
        this.buyMember=buyMember;
        this.getMember=getMember;
        buyMember.getSend_Gifts().add(this);
        getMember.getGifts().add(this);
    }
     */
}
