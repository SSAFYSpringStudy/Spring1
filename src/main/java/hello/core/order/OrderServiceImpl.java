package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService{
    //주문생성 요청이 오면 회원정보를 조회하고 그다음에 할인 정책에다가 회원을 그냥 넘기기
    // 무엇을 넘길지 고민해보며 설계하기 (사람마다 다름)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //우선 멤버 찾기
        Member member = memberRepository.findById(memberId);

        //OrderService입장에서는 할인은 모르겠고 알아서 계산해서 던져달라고 설계한 것 = 단일책임 원칙
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
