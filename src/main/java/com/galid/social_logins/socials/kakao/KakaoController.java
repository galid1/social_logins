package com.galid.social_logins.socials.kakao;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoApiClient kakaoApiClient;

    @GetMapping("/auth/kakao/code")
    public String getAccessToken(@RequestParam("code") String authorizeCode) throws IOException {
        System.out.println("kakao : " + kakaoApiClient.getUniqueId(authorizeCode));

        return "main";
    }


}
