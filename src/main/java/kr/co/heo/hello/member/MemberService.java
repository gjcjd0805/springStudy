package kr.co.heo.hello.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
