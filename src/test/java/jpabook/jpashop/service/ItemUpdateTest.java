package jpabook.jpashop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class ItemUpdateTest {
    @Autowired
    EntityManager em;
    @Test
    void updateTest() throws Exception { //변경 감지와 병합(merge) 설명 시 잠깐 등장
        //given

        //when

        //then


    }
}
