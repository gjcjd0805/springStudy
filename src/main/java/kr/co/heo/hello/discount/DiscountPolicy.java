package kr.co.heo.hello.discount;

import kr.co.heo.hello.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
