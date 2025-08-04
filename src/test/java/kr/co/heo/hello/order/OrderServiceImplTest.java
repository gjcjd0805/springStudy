package kr.co.heo.hello.order;

import kr.co.heo.hello.discount.FixDiscountPolicy;
import kr.co.heo.hello.member.Grade;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order itemA = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);

    }

}