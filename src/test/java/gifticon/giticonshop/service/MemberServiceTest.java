package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
        assertThat(memberService.findByName("준범").get(0).getName()).isEqualTo("준범");
    }
    @Test
    public void 중복_ID_검사_테스트() throws Exception {
        //given
        Member member=makeMember();
        member.setLogin_id("asdf");
        Member member1=makeMember();
        member1.setLogin_id("asdf");
        //when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        //then
        assertThat(e.getMessage()).isEqualTo("Id 중복입니다");
    }
    @Test
    public void 이름으로_찾기() throws Exception {
        //given
        Member member=makeMember();
        //when
        memberService.join(member);
        //then
        List<Member> result = memberService.findByName("준범");
        for (Member m : result) {
            System.out.println(m.toString());
        }
        assertThat(result.size()).isEqualTo(1);
    }
    @Test
    public void 전체_회원목록() throws Exception {
        //given
        Member member=makeMember();
        Member member1=makeMember();
        member1.setName("창훈");
        //when
        memberService.join(member);
        memberService.join(member1);
        //then
        assertThat(memberService.allMember().size()).isEqualTo(2);

    }

}