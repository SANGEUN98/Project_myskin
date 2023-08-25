package TeamA.myskin.config;

import TeamA.myskin.mybatis.*;
import TeamA.myskin.repository.ItemRepository;
import TeamA.myskin.repository.MemberRepository;
import TeamA.myskin.repository.ReviewRepository;
import TeamA.myskin.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final ItemMapper itemMapper;
    private final MemberMapper memberMapper;
    private final ReviewMapper reviewMapper;

    @Bean
    public ItemService itemService() {
        return new ItemService1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }

    @Bean
    public MemberRepository memberRepository() { return new MyBatisMemberRepository(memberMapper);
    }

    @Bean
    public MemberService memberService1(){return new MemberService1(memberRepository());
    }

    @Bean
    public ReviewRepository reviewRepository() { return new MyBatisReviewRepository(reviewMapper);
    }

    @Bean
    public ReviewService reviewService1(){return new ReviewService1(reviewRepository());
    }







}
