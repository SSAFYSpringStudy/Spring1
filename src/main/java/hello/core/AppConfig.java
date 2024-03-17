package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    //이전에는 객체를 생성하고 인터페이스가 무엇인지 MemberServiceImpl에서 직접 정해줬다. (별로)
    //여기서 다 하도록 만들어주자
    //먼저 MemberServiceImpl로 가서 직접적으로 선택된 memoryMemberRepository를 지우고 생성자를 만든다.
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); // 어디선가 AppConfig를 불러서 쓴다면 멤버서비스구현체인 객체가 생성
        //생성자가 여기 있으므로 MemberServiceImpl에 MemortMemberRepositry에 관한 코드가 하나도 없다.
        //MemberServiceImpl에는 오로지 인터페이스만 있다. -> DIP만족
        //이와 같이 생성자를 통해서 객체가 들어가는 것을 생성자 주입이라고 함
    }

    //Order에도 생성자 주입
    //하지만 여긴 상요하는 멤버(할인정책)이 두개다. 두개 다 생성자로 받기
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy()); // 일단 fix
    } // DIP 만족

}
