package gifticon.giticonshop.controller;

import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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


    //이름입력창으로 보내
    @GetMapping("/name")
    public String find(Model model) {
        model.addAttribute("name", "");
        return "members/name";
    }

    //이름 경로를받아서 List보여주는곳으로 보내
    @GetMapping("/{name}")
    public String findMember(@PathVariable String name, Model model) {
        List<Member> result = memberService.findByName(name);
        model.addAttribute(result);
        return "members/memberList";
    }

    @GetMapping("/cash")
    public String chargeCash(Model model) {
        model.addAttribute("cash", 0);
        return "members/chargeCash";
    }
    /*
    //나중에 덧셈
    @PostMapping("chargeCash")
    public String charge(@ModelAttribute("cash") String cash) {

    }
     */
}
