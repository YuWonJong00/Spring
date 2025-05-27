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


}
}