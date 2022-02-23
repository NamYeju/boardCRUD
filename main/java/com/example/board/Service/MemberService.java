package com.example.board.Service;

import com.example.board.model.dto.MemberCreateDto;
import com.example.board.model.dto.MemberSearchDto;
import com.example.board.model.dto.MemberUpdateDto;
import com.example.board.model.entity.Member;
import com.example.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    //회원가입
    public void memberCreate(MemberCreateDto memberCreateDto){
        Member member = Member.builder()
                .identity(memberCreateDto.getIdentity())
                .password(memberCreateDto.getPassword())
                .name(memberCreateDto.getName())
                .age(memberCreateDto.getAge())
                .build();
        memberRepository.save(member);
    }
    //회원정보 조회
    public MemberSearchDto memberSearch(String identity){
        MemberSearchDto memberSearchDto = new MemberSearchDto();
        Member member = memberRepository.findByIdentity(identity);
        if(member == null){
            throw new userNotFoundException(String.format("id[%s]is not found", identity));
        }
        memberSearchDto.setIdentity(member.getIdentity());
        memberSearchDto.setName(member.getName());
        return memberSearchDto;
    }
    //회원정보수정
    public void memberUpdate(MemberUpdateDto memberUpdateDto){
        Member member = memberRepository.findByIdentity(memberUpdateDto.getIdentity());
        member.update(member.getName());
        memberRepository.save(member);
    }
    //회원정보 삭제
    public void memberDelete(String identity){
        Member member = memberRepository.findByIdentity(identity);
        memberRepository.delete(member);
    }
}
