package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
//AppConfig는 중복을 없애고 각자의 역할을 명시한다.

    //@Bean memberService -> new MemoryMemberRepository();
    //@Bean orderService -> new MemoryMemberRepository();

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    @Bean
    public MemberService memberService(){
        System.out.println(" call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());

    }
  @Bean
  public MemberRepository memberRepository() {
      System.out.println(" call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println(" call AppConfig.orderService");
        return new OrderServiceImpl(discountPolicy(), memberRepository());

    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
