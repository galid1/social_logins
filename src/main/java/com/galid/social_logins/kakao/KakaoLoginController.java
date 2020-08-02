package com.galid.social_logins.kakao;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class KakaoLoginController {
    private final ObjectMapper objMapper;

    private String clientId = "2fd5cececbba62e7626740a6d6632296";
    private String redirectUrl = "http://localhost/auth/kakao/code";

    @GetMapping("/auth/kakao/code")
    public String getAccessToken(@RequestParam("code") String authorizeCode) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(makeGetAccessTokenUrl(authorizeCode))
                .post(RequestBody.create("", MediaType.get("application/json; charset=utf-8")))
                .build();
        Response response = client.newCall(request).execute();

        KakaoAccessToken token = objMapper.readValue(response.body().string(), KakaoAccessToken.class);

        return "redirect:/auth/kakao/users?access_token=" + token.getAccess_token();
    }

    private String makeGetAccessTokenUrl(String authorizeCode) {
        return "https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id=" + clientId
                + "&redirect_uri=" + redirectUrl
                + "&code=" + authorizeCode;
    }

    @GetMapping("/auth/kakao/users")
    public String getUserInformation(@RequestParam("access_token") String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://kapi.kakao.com/v2/user/me")
                .post(RequestBody.create("", MediaType.get("application/json; charset=utf-8")))
                .header("Authorization", "Bearer " + accessToken)
                .build();

        System.out.println("kakao : " + client.newCall(request)
                .execute().body().string());

        return "main";
    }

}
