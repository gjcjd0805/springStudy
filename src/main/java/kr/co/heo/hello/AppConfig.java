package kr.co.heo.hello;

import kr.co.heo.hello.discount.FixDiscountPolicy;
import kr.co.heo.hello.member.MemberService;
import kr.co.heo.hello.member.MemberServiceImpl;
import kr.co.heo.hello.member.MemoryMemberRepository;
import kr.co.heo.hello.order.OrderService;
import kr.co.heo.hello.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
