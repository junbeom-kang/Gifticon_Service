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
    private String name;
    @OneToMany(mappedBy = "member") //필드에서 초기화가 best practice
    private List<Gift> Gifts=new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Gift> Send_Gifts=new ArrayList<>();

}
