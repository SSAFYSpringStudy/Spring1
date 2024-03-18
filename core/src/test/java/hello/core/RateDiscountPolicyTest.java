package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 필요")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int price = discountPolicy.discount(member, 20000);
        //then
        assertThat(price).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        //when
        int price = discountPolicy.discount(member, 10000);
        //then
        assertThat(price).isEqualTo(0);
    }
}
