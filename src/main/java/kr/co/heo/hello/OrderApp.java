package kr.co.heo.hello;

import kr.co.heo.hello.member.Grade;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemberService;
import kr.co.heo.hello.member.MemberServiceImpl;
import kr.co.heo.hello.order.Order;
import kr.co.heo.hello.order.OrderService;
import kr.co.heo.hello.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 2000);

        System.out.println("order = " + order);

    }
}
