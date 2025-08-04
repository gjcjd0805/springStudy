package kr.co.heo.hello.autowired;

import jakarta.annotation.Nullable;
import kr.co.heo.hello.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.bean.override.convention.TestBean;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        @Autowired(required = false)
        public void seNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired
        public void seNoBean2(@Nullable  Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void seNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
