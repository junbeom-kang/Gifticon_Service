package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
@Transactional
class MemberServiceTest {
    @Autowired MemberRepository memberRepository;

    @Test
    public void 멤버_저장_테스트() throws Exception {
        //given
        Member member=new Member();
        member.setCash(1000L);
        member.setName("준범");
        //when
        memberRepository.save(member);

        //then
        Assertions.assertThat("준범").isEqualTo(memberRepository.findByName("준범").get(0).getName());

    }

}