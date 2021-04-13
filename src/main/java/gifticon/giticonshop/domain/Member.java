package gifticon.giticonshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private Long cash;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", cash=" + cash +
                ", name='" + name + '\'' +
                '}';
    }

    private String name;
/*
    @OneToMany(mappedBy = "buyMember")//필드에서 초기화가 best practice
    private List<Gift> Send_Gifts=new ArrayList<>();

    @OneToMany(mappedBy = "buyMember")
    private List<Gift> Gifts=new ArrayList<>();
 */
}
