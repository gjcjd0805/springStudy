package kr.co.heo.hello.member;

import kr.co.heo.hello.AppConfig;
import kr.co.heo.hello.order.Order;
import kr.co.heo.hello.order.OrderService;
import kr.co.heo.hello.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Member member = new Member(1L, "멤버1", Grade.VIP);
        memberService.join(member);

        Order order =orderService.createOrder(member.getId(), "짜장면", 2000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(200);

    }
}
