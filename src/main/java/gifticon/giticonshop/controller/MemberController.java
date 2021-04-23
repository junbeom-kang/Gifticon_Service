package gifticon.giticonshop.controller;

import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/members/createForm";
    }

    @PostMapping("/new")
    public String create(@Valid MemberForm memberForm, BindingResult result) {
        if (result.hasErrors()) {
            return "/members/createForm";
        }
        Member member = new Member();
        member.setName(memberForm.getName());
        member.setCash(0);
        member.setLogin_id(memberForm.getLogin_id());
        member.setPassword(memberForm.getPassword());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String all() {
        return "members/all";
    }

    @GetMapping("/name")
    public String find() {
        return "members/name";
    }

    @GetMapping("members/{name}")
    public String findMember(@PathVariable String name,Model model) {
        List<Member> result = memberService.findByName(name);
        model.addAttribute(result);
        return "members/memberList";
    }
}
