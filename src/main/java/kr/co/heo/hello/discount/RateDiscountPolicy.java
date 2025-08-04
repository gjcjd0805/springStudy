package kr.co.heo.hello.discount;

import kr.co.heo.hello.annotation.MainDiscountPolicy;
import kr.co.heo.hello.member.Grade;
import kr.co.heo.hello.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int rate = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return price * rate / 100;
        } else {
            return 0;
        }
    }
}
