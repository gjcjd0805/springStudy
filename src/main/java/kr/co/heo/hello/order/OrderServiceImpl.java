package kr.co.heo.hello.order;

import kr.co.heo.hello.discount.DiscountPolicy;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(1L, "짜장면", 2000, discountPrice);
    }
}
