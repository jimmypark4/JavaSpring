package hello.servlet.domain.member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
//
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용

    //싱글톤으로 사용,
    private static final MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository() {
    }

    //저장기능
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    //조회기능
    public Member findById(Long id) {
        return store.get(id);
    }
    //전체조회
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    //저장소 전체 삭제, 테스트 용으로만 사용
    public void clearStore() {
        store.clear();
    }
}