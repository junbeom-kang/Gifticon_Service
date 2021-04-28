package gifticon.giticonshop.controller;

import gifticon.giticonshop.controller.DTOForm.GiftForm;
import gifticon.giticonshop.domain.Gift;
import gifticon.giticonshop.domain.Member;
import gifticon.giticonshop.exception.NoMemberNameException;
import gifticon.giticonshop.service.GiftService;
import gifticon.giticonshop.service.GiftServiceImpl;
import gifticon.giticonshop.service.ItemServiceImpl;
import gifticon.giticonshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gift")
@RequiredArgsConstructor
public class GiftController {
    private final GiftServiceImpl giftService;
    private final MemberService memberService;
    private final ItemServiceImpl itemService;

    /**
     * 구매
     */
    @GetMapping("/buy")
    public String createGift(@ModelAttribute String name, Model model) {
        List<Member> members = memberService.findByName(name);
        if (members.size() == 0) {
            throw new NoMemberNameException("해당 이름의 회원이 없습니다");
        }
        model.addAttribute("member", members);
        model.addAttribute("giftForm", new GiftForm());
        return "/gift/createGiftForm";
    }

    @PostMapping("buy")
    public String create(@RequestParam("buyId") Long buyerId,
                         @RequestParam("getterId") Long getterId,
                         @RequestParam("itemId") Long itemId,
                         @RequestParam("count") int count) {
        giftService.make(buyerId, getterId, itemId, count);
        return "redirect:/";
    }

    @GetMapping("myGift/{id}")
    public String giftList(@PathVariable("id") Long myId,Model model) {
        List<Gift> result = giftService.find_By_Getter(myId);
        model.addAttribute("gifts", result);
        model.addAttribute("Name", "받은 선물함");
        return "/gift/giftList";
    }
}
