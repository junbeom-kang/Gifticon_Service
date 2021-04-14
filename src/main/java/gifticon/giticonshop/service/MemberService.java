package gifticon.giticonshop.service;

import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public void join(Member member) {
        if (!memberRepository.findByLoginId(member.getLogin_id()).isEmpty()) {
            throw new IllegalStateException("Id 중복입니다");
        }
        memberRepository.save(member);
    }

    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> allMember() {
        return memberRepository.findAll();
    }


}
