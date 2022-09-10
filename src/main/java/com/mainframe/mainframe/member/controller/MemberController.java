package com.mainframe.mainframe.member.controller;

import com.mainframe.mainframe.member.dto.MemberDto;
import com.mainframe.mainframe.member.dto.MemberPostDto;
import com.mainframe.mainframe.member.entity.Member;
import com.mainframe.mainframe.member.mapper.MemberMapper;
import com.mainframe.mainframe.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/members")  // Member로 해야 할지, Host로 해야 할지 결정. 권한 문제도 있음.
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto requestBody) {
        Member member = memberMapper.memberPostToMember(requestBody);
        Member createdMember = memberService.createMember(member);
        MemberDto.Response response = memberMapper.memberToMemberResponse(createdMember);
        return new ResponseEntity<>();
    }

    @PutMapping("/{member-id}")
    public ResponseEntity putMember(
            @PathVariable("member-id") @Positive Long memberId,
            @Valid @RequestBody MemberDto.Put requestBody) {
        requestBody.setMemberId(memberId);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {
    }

    @GetMapping // 페이지가 아닌, 리스트로 넘김 (Roobits를 전체로 넘기려면 여기에서는 페이지로 넘겨도 상관 없음..
    // 사실 페이지든 리스트든 멤버를 한번에 받을 필요는 없을 듯함)
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = memberService.findMembers();
        return new ResponseEntity<>();
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(
            @PathVariable("member-id") @Positive Long memberId {
    }
}
