package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userAprice = statefulService1.order("userA", 10000);
        int userBprice = statefulService2.order("userB", 20000);

        /*
        // ThreadA: A사용자 10000원 주문
        statefulService1.order("userA", 10000);

        // ThreadB: B사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA: A사용자가 주문 금액을 조회함
        int price = statefulService1.getPrice();
        System.out.println("price= "+price);
        // A가 주문하고 금액을 조회하는 사이에 B가 중간에 끼어들어서 주문한 상황

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);*/

    }

    static class TestConfig{
        //statefulService 전용 config을 하나 만든다.

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}