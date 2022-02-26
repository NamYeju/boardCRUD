package com.example.board.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "board_member")
@Data
@AllArgsConstructor
@Builder
public class Member{
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identity;

    private String password;

   @Size(min = 3, message = "이름 최소 3글자")
    private String name;

    private int age;

    public Member() {

    }

    //    //Builder Class
//    public static class MemberBuilder{
//        //required parameters
//        private String identity;
//        private String password;
//        private String name;
//
//        //optional parameters
//        private int age;
//
//        public MemberBuilder(String identity, String password, String name) {
//            this.identity = identity;
//            this.password = password;
//            this.name = name;
//        }
//        public MemberBuilder age(int age){
//            this.age = age;
//            return this;
//        }
//
//        public Member build(){
//            return new Member(this);
//        }
//    }
    public void update(String name){
        this.name = name;
    }


}
