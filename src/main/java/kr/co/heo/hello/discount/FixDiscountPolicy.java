package kr.co.heo.hello.discount;

import kr.co.heo.hello.member.Grade;
import kr.co.heo.hello.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }

        return 0;
    }
}
