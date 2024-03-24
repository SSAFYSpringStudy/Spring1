package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //appConfig에서 memberService를 달라고 하면
        // -> MemberServiceImpl 을 만들고, 내가 만든건 멤버리파지토리를 사용할거야라고 주입함


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService= applicationContext.getBean("memberService", MemberService.class);


//        MemberService memberService = new MemberServiceImpl();
        // 기존에는 멤버서비스인플을 직접 생성함 -> 멤버서비스인플에서 메모리멤버리파지토리를 생성함 (마치 순차적으로 보임)
        // 앱컨피그를 사용하면 앱컨피그에서 다 결정을 함
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember: "+findMember.getName());
        System.out.println("member: "+member.getName());
    }
}
