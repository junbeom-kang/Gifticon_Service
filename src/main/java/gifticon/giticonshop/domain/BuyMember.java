package gifticon.giticonshop.domain;

import javax.persistence.*;
@Entity
public class BuyMember {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member buyMember;
    @Column(name = "buy_id")
    private Long buyPK;
    public BuyMember buyMember(Member member) {
        BuyMember buyMember=new BuyMember();
        this.buyMember=member;
        this.buyPK=member.getId();
        return buyMember;

    }

}
