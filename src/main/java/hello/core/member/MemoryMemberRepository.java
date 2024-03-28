package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{
    //저장소가 확정되지 않아서 memorymemberrepository로 그냥 개발
    //테스트만 가능
    private static Map<Long, Member> store = new HashMap<>();
    //동시성 이슈가 있을 수 있으므로 ConcurrentHashMap을 써야한다(실무에서는)
    //연습이니 간단하게
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
