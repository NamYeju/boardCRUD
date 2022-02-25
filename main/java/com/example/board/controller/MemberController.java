package com.example.board.controller;

import com.example.board.Service.MemberService;
import com.example.board.Service.userNotFoundException;
import com.example.board.model.dto.MemberCreateDto;
import com.example.board.model.dto.MemberSearchDto;
import com.example.board.model.dto.MemberUpdateDto;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        MemberSearchDto membersearchDto = memberService.memberSearch(identity);
        if(membersearchDto == null){
            throw new userNotFoundException(String.format("id[%s]is not found", identity));
        }
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
