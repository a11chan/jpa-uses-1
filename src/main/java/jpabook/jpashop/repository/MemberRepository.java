package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {


    //    @PersistenceContext //생성자 주입으로 대체 가능
    // @Autowired // 생성자 1개이면 생략 가능, @PersistenceContext 사용해야 하나 SpringDataJPA가 지원
    private final EntityManager em;

//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    } // @RequiredArgsConstructor로 생략 가능 - final 필드 초기화

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
            .getResultList(); //from의 대상이 Table이 아닌 Entity 대상 쿼리
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
            .setParameter("name", name)
            .getResultList();
    }
}
