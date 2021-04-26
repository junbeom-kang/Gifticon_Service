package gifticon.giticonshop.controller;

import gifticon.giticonshop.domain.Item;
import gifticon.giticonshop.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String createItemForm(Model model) {
        model.addAttribute("itemForm", new ItemForm());
        return "items/createItemForm";
    }

    @PostMapping("/new")
    public String createItem(@Valid ItemForm itemForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/items/new";
        }
        Item item=new Item();
        item.setName(itemForm.getName());
        item.setStock(itemForm.getStock());
        item.setPrice(itemForm.getPrice());
        itemServiceImpl.join(item);
        return "redirect:/";
    }
}
