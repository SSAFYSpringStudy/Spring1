package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);//TestBean이 스프링 빈으로 등록된다.

    }

    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            //Member은 스프링과 관련된 빈이 아니다. = 스프링 컨테이너에 관리되는게 없다.
            System.out.println("noBean1 = "+noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = "+noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = "+noBean3);
        }

    }

}
