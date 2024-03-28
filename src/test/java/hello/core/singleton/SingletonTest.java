package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    //우리가 만든 순수한 DI 컨테이너가 가진 문제점을 보고, 스프링과 비교해볼 것이다.
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때마다 객체를 생성하는지 조회
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때마다 객체를 생성하는지 조회
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인한다.
        System.out.println("memberService1: "+memberService1);
        System.out.println("memberService2: "+memberService2);

        // 테스트는 눈으로 확인하면 안되고 항상 아래처럼 검증해야 한다.
        // memberService1은 2와 달라야 한다.
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void SingletonServiceTest(){
        SingletonService singletonservice1 = SingletonService.getInstance();
        SingletonService singletonservice2 = SingletonService.getInstance();

        System.out.println("singletonService1: "+ singletonservice1);
        System.out.println("singletonService2: "+ singletonservice2);

        assertThat(singletonservice1).isSameAs(singletonservice2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

//        AppConfig appConfig = new AppConfig();
//        얘를 스프링으로 바꾸면 된다.

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 다른 것을 확인한다.
        System.out.println("memberService1: "+memberService1);
        System.out.println("memberService2: "+memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

}
