package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {

    //join을 위해서 필드에 memberService 생성
    MemberService memberService;
    @BeforeEach // 테스트를 실행하기 전에 무조건 실행
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    //junit으로 테스트 해보기
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
