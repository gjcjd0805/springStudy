package kr.co.heo.hello;

import kr.co.heo.hello.discount.DiscountPolicy;
import kr.co.heo.hello.discount.FixDiscountPolicy;
import kr.co.heo.hello.discount.RateDiscountPolicy;
import kr.co.heo.hello.member.MemberRepository;
import kr.co.heo.hello.member.MemberService;
import kr.co.heo.hello.member.MemberServiceImpl;
import kr.co.heo.hello.member.MemoryMemberRepository;
import kr.co.heo.hello.order.OrderService;
import kr.co.heo.hello.order.OrderServiceImpl;
import kr.co.heo.hello.point.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public PointUse pointUse(){
        return new PointUseImpl();
    }

    @Bean
    public PointGet pointGet(){
        return new PointGetImpl();
    }

    public Point point(){
        return new PointImpl(
                pointUse(),
                pointGet()
        );
    }
}
