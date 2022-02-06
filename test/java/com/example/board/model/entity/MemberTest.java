package com.example.board.model.entity;

import com.example.board.Service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {


    @Autowired
    private MemberService memberService;

//    @Test
//    public void memberinsert(){
//        Member member = new Member.MemberBuilder("dpwn", "1234", "nam")
//                .age(23)
//                .build();
//        Assertions.assertThat(member.getName()).isEqualTo("nam");
//    }

    @Test
    public  void builderinsert(){
        Member member = Member.builder()
                .identity("123")
                .name("dpwn")
                .password("123")
                .age(23)
                .build();
        Assertions.assertThat(member.getName()).isEqualTo("dpwn");
    }
}