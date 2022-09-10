package com.mainframe.mainframe.jwt.controller;

import com.mainframe.mainframe.member.entity.Member;
import com.mainframe.mainframe.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public @ResponseBody String index() {
        return "index";
    }

    @GetMapping("/guest")
    public @ResponseBody String guest() {
        return "guest";
    }

    @GetMapping("/host")
    public @ResponseBody String host() {
        return "host";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }
    @GetMapping("/login")
    public @ResponseBody String login() {
        return "loginForm";
    }

    @GetMapping("/join")
    public @ResponseBody String join() {
        return "joinForm";
    }

    @PostMapping("/join")
    public @ResponseBody String join(Member member) {
        member.setRole("ROLE_HOST");
        String rawPassword = member.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        member.setPassword(encPassword);

        memberRepository.save(member);
        return "redirect:/login";
    }
}
