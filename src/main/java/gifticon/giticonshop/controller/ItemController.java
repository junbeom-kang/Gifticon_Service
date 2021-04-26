package gifticon.giticonshop.controller;

import gifticon.giticonshop.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemServiceImpl itemServiceImpl;

    /**
     * 아이템 목록
     */
    @GetMapping("")
    public String itemList() {
        return "/items/itemList";
    }

    @GetMapping("/new")
    public String newItem(Model model) {
        ItemForm itemForm()=new ItemForm();
    }
}
