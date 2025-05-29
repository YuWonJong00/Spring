package hello.core.Order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
@Test
    void createOrder() {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    MemberRepository memberRepository=new MemoryMemberRepository();
    OrderServiceImpl orderService = new OrderServiceImpl(discountPolicy, memberRepository);
    orderService.createOrder(1L, "itemA", 10000);

//final과 생성자 주입을 사용하면 순수 자바 코드로 테스트를 작성할 때 의존관계를 누락하지 않도록 안정성을 보장해준다


}
}