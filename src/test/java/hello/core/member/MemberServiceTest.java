package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class MemberServiceTest {

    //join을 위해서 필드에 memberService 생성
    MemberService memberService = new MemberServiceImpl();

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
