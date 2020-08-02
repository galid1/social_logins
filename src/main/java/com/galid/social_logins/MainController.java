package com.galid.social_logins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigInteger;
import java.security.SecureRandom;

@Controller
public class MainController {
    @GetMapping("/join")
    public String getJoinPage() {
        return "join";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("csrfToken", generateToken());
        return "login";
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
