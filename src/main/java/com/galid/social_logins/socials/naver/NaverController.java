package com.galid.social_logins.socials.naver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galid.social_logins.socials.naver.vo.NaverAccessToken;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class NaverController {
    private final NaverApiClient naverApiClient;

    @GetMapping("/auth/naver/code")
    public String getAccessToken(@RequestParam("code") String authorizeCode) throws IOException {
        System.out.println(naverApiClient.getUniqueId(authorizeCode));
        return "main";
    }

}
