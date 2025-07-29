package kr.co.heo.hello.beankind;

import kr.co.heo.hello.AppConfig;
import kr.co.heo.hello.member.MemberRepository;
import kr.co.heo.hello.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextSameBeanFindTest{

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 중복 오류가 발생")
    void findBeanByTypeDuplicate(){

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            MemberRepository bean = ac.getBean(MemberRepository.class);
        });

    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정")
    void findBeanByName(){
        MemberRepository bean = ac.getBean("memberRepository1",MemberRepository.class);
        assertThat(bean).isInstanceOf(MemberRepository.class);

    }

    @Test
    @DisplayName("특정 타입을 모두 조회")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (Map.Entry<String, MemberRepository> entry : beansOfType.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = "+ entry.getValue());
        }

        assertThat(beansOfType.size()).isEqualTo(2);
    }

    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
