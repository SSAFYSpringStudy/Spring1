package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //가입을 하고 회원을 찾기 위해서 앞에서 만들었던 저장소가 필요
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //구현체 없이 null로 놔두면 오류 발생 -> 구현 객체를 선택해줘야 함
    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //다형성에 의해서 인터페이스가 아니라 MemoryMemberRepository에 있는 override한 save가 호출
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
