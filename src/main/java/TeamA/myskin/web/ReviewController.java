package TeamA.myskin.web;

import TeamA.myskin.domain.Item;
import TeamA.myskin.domain.Review;
import TeamA.myskin.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.bytecode.FieldInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

//    @GetMapping("/view") //@PathVariable long itemId,
//    public String reviewList(Model model) {
//        //FieldInfo model;
//        Review review = reviewService.findById(loginId).get();
//        model.addAttribute("reviews", reviews);
//        return "/product/view";
//    }
//    @GetMapping("/view") //@PathVariable long itemId,
//    @GetMapping("/{pid}") //@PathVariable long itemId,
//    public String reviewView(@PathVariable int pid, Model model) {
//        Review review = reviewService.findById(pid).get();
//        model.addAttribute("review", review);
//        return "/product/view";
//    }

}
