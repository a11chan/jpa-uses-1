package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;
    @Embedded
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member") //참조되는 필드는 클래스 다이어그램에서 List로 표현
    private List<Order> orders = new ArrayList<>();

}
