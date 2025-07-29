package kr.co.heo.hello.beankind;

import kr.co.heo.hello.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = context.getBean(beanDefinitionName);
            System.out.println("bane = " + beanDefinitionName + ", object = " + bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력")
    void findApplicationBean() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = context.getBean(beanDefinitionName);
                System.out.println("bane = " + beanDefinitionName + ", object = " + bean);
            }
        }
    }
}
