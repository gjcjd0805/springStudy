package kr.co.heo.hello;

import kr.co.heo.hello.member.Grade;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemberService;
import kr.co.heo.hello.order.Order;
import kr.co.heo.hello.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 20000);

        System.out.println("order = " + order);

    }
}
