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
    private String login_id;
    private String password;
    private Long cash;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", cash=" + cash +
                ", name='" + name + '\'' +
                '}';
    }

}
