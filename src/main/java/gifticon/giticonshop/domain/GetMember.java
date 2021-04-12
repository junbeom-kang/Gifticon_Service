package gifticon.giticonshop.domain;

import javax.persistence.*;

@Entity
public class GetMember {
    @Id @GeneratedValue
    @Column
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member getMember;
    @Column(name = "get_id")
    private Long getPK;

    public GetMember getMember(Member member) {
        GetMember getMember=new GetMember();
        this.getMember=member;
        this.getPK= member.getId();
        return getMember;

    }
}
