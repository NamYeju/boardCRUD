package com.example.board.model.entity;

import com.sun.istack.NotNull;
import lombok.*;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "board_member")
@Getter @Setter
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
