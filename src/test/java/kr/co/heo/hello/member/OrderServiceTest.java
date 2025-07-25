package kr.co.heo.hello.member;

import kr.co.heo.hello.order.Order;
import kr.co.heo.hello.order.OrderService;
import kr.co.heo.hello.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Member member = new Member(1L, "멤버1", Grade.VIP);
        memberService.join(member);

        Order order =orderService.createOrder(member.getId(), "짜장면", 2000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
