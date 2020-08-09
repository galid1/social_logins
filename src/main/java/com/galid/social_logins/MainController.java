package com.galid.social_logins;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.security.SecureRandom;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String getJoinPage(Model model) {
        model.addAttribute("csrfToken", generateToken());
        return "join";
    }

    @GetMapping("/doJoin")
    public String join(@ModelAttribute MemberJoinRequest request) {
        memberService.signUp(request);
        return "main";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("csrfToken", generateToken());
        return "join";
    }

    private String generateToken() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
