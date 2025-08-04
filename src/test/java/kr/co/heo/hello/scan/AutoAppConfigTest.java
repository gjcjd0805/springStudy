package kr.co.heo.hello.scan;

import kr.co.heo.hello.AutoAppConfig;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {


    @Test
    void basicScan(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
