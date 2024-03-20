package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefuleServiceSingleton(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statfulService1 = ac.getBean(StatefulService.class);
        StatefulService statfulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자가 10000원 주문
        int userAPrice = statfulService1.order("userA",10000);
        //ThreadB : B사용자가 20000원 주문
        int userBPrice = statfulService2.order("userB",20000);

        //ThreadA : 사용자 A가 주문 금액 조회
//        int price = statfulService1.getPrice();
        System.out.println("price = "+userAPrice);

        //2만원이 나옴 , 기대했던 값과 다름
        //중간에 사용자 B가 공유객체를 바꿔버림
//        Assertions.assertThat(statfulService1.getPrice()).isEqualTo(20000);
    }

    static  class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}