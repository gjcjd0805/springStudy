package kr.co.heo.hello.beankind;

import kr.co.heo.hello.AppConfig;
import kr.co.heo.hello.discount.DiscountPolicy;
import kr.co.heo.hello.discount.FixDiscountPolicy;
import kr.co.heo.hello.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

    @Test
    @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있으면, 중복 오류 발생")
    void findBeanByParentTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            DiscountPolicy bean = context.getBean(DiscountPolicy.class);
        });
    }
    @Test
    @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있으면, 빈 이름을 지정")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy bean = context.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있으면, 타입으로 지정")
    void findBeanBySubType(){
        DiscountPolicy bean = context.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beansOfType = context.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (Map.Entry<String, DiscountPolicy> entry : beansOfType.entrySet()) {
            System.out.println("key = "+entry.getKey()+", value = "+entry.getValue());
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = context.getBeansOfType(Object.class);
        for (Map.Entry<String, Object> entry : beansOfType.entrySet()) {
            System.out.println("key = "+entry.getKey()+", value = "+entry.getValue());
        }
    }

}
