package kr.co.heo.hello.order;

import kr.co.heo.hello.discount.DiscountPolicy;
import kr.co.heo.hello.discount.FixDiscountPolicy;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemberRepository;
import kr.co.heo.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(1L, "짜장면", 2000, discountPrice);
    }
}
