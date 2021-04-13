package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
@Transactional
class MemberServiceTest {
    @Autowired MemberService memberService;
    static Member makeMember() {
        Member member=new Member();
        member.setCash(1000L);
        member.setName("준범");
        return member;
    }
    @Test
    public void 멤버_저장_테스트() throws Exception {
        //given
        Member member=makeMember();
        //when
        memberService.join(member);

        //then
        assertThat("준범").isEqualTo(memberService.findByName("준범").get(0).getName());

    }
    @Test
    public void 이름으로_찾기() throws Exception {
        //given
        Member member=makeMember();
        //member.setName("창훈");
        //when
        memberService.join(member);
        //then
        List<Member> result = memberService.findByName("준범");
        for (Member m : result) {
            System.out.println(m.toString());
        }
        assertThat(3).isEqualTo(result.size());
    }
    @Test
    public void 전체_회원목록() throws Exception {
        assertThat(4).isEqualTo(memberService.allMember().size());

    }

}