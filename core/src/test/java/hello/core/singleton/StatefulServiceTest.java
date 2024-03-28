package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //TreadA: A사용자 10000원 주문
        int userA = statefulService1.order("userA", 10000);

        //TreadB: B사용자 20000원 주문
        int userB = statefulService2.order("userB", 20000);

        //TreadA: 사용자 A 주문 금액 조회
//        int price = statefulService1.getPrice();//10000원 나와야 함
        System.out.println("price = " + userA);

        //A 사용자의 금액이 20000원으로 바뀌게 됨 -> 망함
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}