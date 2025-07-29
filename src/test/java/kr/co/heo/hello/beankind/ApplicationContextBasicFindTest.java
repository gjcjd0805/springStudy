package kr.co.heo.hello.beankind;

import kr.co.heo.hello.AppConfig;
import kr.co.heo.hello.member.MemberService;
import kr.co.heo.hello.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("memberService: " + memberService);
        System.out.println("memberService.getClass(): " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = context.getBean(MemberService.class);
        System.out.println("memberService: " + memberService);
        System.out.println("memberService.getClass(): " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = context.getBean(MemberServiceImpl.class);
        System.out.println("memberService: " + memberService);
        System.out.println("memberService.getClass(): " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            context.getBean("X",MemberServiceImpl.class);
        });
    }

}
