package gifticon.giticonshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter @Setter
public class Gift {
    @Id @GeneratedValue
    @Column(name="gift_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="item_id")
    private Item item;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JoinColumn(referencedColumnName = "member_id")
    //@JoinColumn(name = "buyMember_id")
    @JoinColumn
    private Member buyMember;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JoinColumn(referencedColumnName = "member_id")
    //@JoinColumn(name = "getMember_id")
    @JoinColumn
    private Member getMember;

    private String giftCode;

    private LocalDateTime orderDate;

    private int count;
    @Enumerated(EnumType.STRING)
    private Used Use;

    public static Gift createGift(Member buyMember, Member getMember, Item item, int count) {
        Gift gift=new Gift();
        gift.setBuyMember(buyMember);
        gift.setGetMember(getMember);
        gift.setItem(item);
        gift.setCount(count);
        gift.setUse(Used.UNUSED);
        gift.setOrderDate(LocalDateTime.now());
        gift.setGiftCode(UUID.randomUUID().toString());
        return gift;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", buyMember=" + buyMember +
                ", getMember=" + getMember +
                ", item=" + item +
                ", giftCode='" + giftCode + '\'' +
                ", orderDate=" + orderDate +
                ", count=" + count +
                ", Use=" + Use +
                '}';
    }
}


