package com.example.board.controller;

import com.example.board.Service.MemberService;
import com.example.board.model.dto.MemberCreateDto;
import com.example.board.model.dto.MemberSearchDto;
import com.example.board.model.dto.MemberUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/memberCreate")
    public void createMember(@RequestBody MemberCreateDto memberCreateDto){
        memberService.memberCreate(memberCreateDto);
    }
    @GetMapping("/memberSearch")
    public MemberSearchDto memberSearch(@RequestParam String identity){
        return memberService.memberSearch(identity);
    }

    @PutMapping("/memberUpdate")
    public void memberUpdate(@RequestBody MemberUpdateDto memberUpdateDto){
        memberService.memberUpdate(memberUpdateDto);
    }
    @DeleteMapping("/memberDelete")
    public void memberDelete(@RequestParam String identity){
        memberService.memberDelete(identity);
    }
}
