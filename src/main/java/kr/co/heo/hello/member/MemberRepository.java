package kr.co.heo.hello.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
