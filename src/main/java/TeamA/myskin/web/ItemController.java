package TeamA.myskin.web;

import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.Review;
import TeamA.myskin.domain.member.Member;
import TeamA.myskin.repository.ItemSearchCond;
import TeamA.myskin.repository.ReviewSearchCond;
import TeamA.myskin.service.ItemService;
import TeamA.myskin.service.MemberService;
import TeamA.myskin.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ReviewService reviewService;
    private final MemberService memberService;

    @GetMapping("/list") //@PathVariable long itemId,
    public String itemList(Model model) {
         return "/product/list";
    }

    @GetMapping("/goods_list") // 메인 리스트 페이지에서 리스트들 동적으로 불러오는거
    public String goodList(@ModelAttribute("itemSearch") ItemSearchCond itemSearch, Model model){
        List<Item> items = itemService.findItems(itemSearch);
        model.addAttribute("items", items);
        return "/product/goods_list";
    }
    @RequestMapping("/goods_list") // 메인 리스트 페이지에서 리스트들 동적으로 불러오는거
    public String goodListR(){
        return "redirect:/product/goods_list";
    }
//  되는거 백업
//    @RequestMapping("/goods_list") // 메인 리스트 페이지에서 리스트들 동적으로 불러오는거
//    public String goodListR(@ModelAttribute("itemSearch") ItemSearchCond itemSearch, Model model){
//        List<Item> items = itemService.findItems(itemSearch);
//        model.addAttribute("items", items);
//        return "redirect:/product/goods_list";
//    }

//    @RequestMapping("/{viewId}")
//    public String itemViewR(){
//        return "redirect:/product/view";
//    }
//    @GetMapping("/{viewId}")
//    public String itemViewR(){
//        return "/product/view";
//    }

    @GetMapping("/{pid}") //@PathVariable long itemId,
    public String itemView(@PathVariable int pid,  Model model) {
        Item item = itemService.findById(pid).get();
        model.addAttribute("item", item);
        List<Review> reviews = reviewService.findReviews(pid);
        //Review review = reviewService.findById(pid).get();
        model.addAttribute("reviews", reviews);
        return "/product/view";
    }
    @GetMapping("/{pid}/{loginId}") //@PathVariable long itemId,
    public String loginitemView(@PathVariable int pid, @PathVariable int loginId, Model model) {
        Item item = itemService.findById(pid).get();
        model.addAttribute("item", item);
        List<Review> reviews = reviewService.findReviews(pid);
        //Review review = reviewService.findById(pid).get();
        model.addAttribute("reviews", reviews);


        Long id = (long)loginId;
        Member member = memberService.findById(id).get();
        model.addAttribute("member", member);
        return "/product/loginview";
    }



}
