package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepositoryOld memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("wiki");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
        //true가 나오는 이뉴는 회원기능 테스트 강의 04:00 이후부터 나옴
        //같은 Tx, 같은 Entity -> 같은 PC에서 관리

    }

    @Test
    void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        //when
        assertThrows(IllegalStateException.class,
            () -> memberService.join(member2)
        );
        //then
        //fail("예외가 발생해야 합니다.");

    }
}