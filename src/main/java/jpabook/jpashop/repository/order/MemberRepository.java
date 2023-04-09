package jpabook.jpashop.repository.order;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //select m from Member m where m.name = ? 이렇게 자동 생성, 따로 구현 안 해도 되지만 네이밍 규칙 준수필 findByXxxx
    List<Member> findByName(String name);
}