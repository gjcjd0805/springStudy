package kr.co.heo.hello;

import kr.co.heo.hello.member.Grade;
import kr.co.heo.hello.member.Member;
import kr.co.heo.hello.member.MemberService;
import kr.co.heo.hello.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = "+ memberA.getName());
        System.out.println("find Member = "+ findMember.getName());
    }
}
