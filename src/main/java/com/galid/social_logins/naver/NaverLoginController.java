package com.galid.social_logins.naver;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class NaverLoginController {
    private final ObjectMapper objMapper;

    private String clientId = "6jdWKyokOP5L5bpCtYOx";
    private String clientSecret = "Mh8pNDKBuf";

    @GetMapping("/auth/naver/code")
    public String getAccessToken(@RequestParam("code") String authorizeCode) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(makeGetAccessTokenUrl(authorizeCode))
                .get()
                .build();

        Response response = client.newCall(request)
                .execute();

        NaverAccessToken naverAccessToken = objMapper.readValue(response.body().string(), NaverAccessToken.class);
        return "redirect:/auth/naver/users?access_token=" + naverAccessToken.getAccess_token();
    }

    private String makeGetAccessTokenUrl(String authorizeCode) {
        return "https://nid.naver.com/oauth2.0/token?client_id=" + clientId
                + "&client_secret=" + clientSecret
                + "&grant_type=authorization_code"
                + "&code=" + authorizeCode;
    }

    @GetMapping("/auth/naver/users")
    public String getUserInformation(@RequestParam("access_token") String accessToken) throws IOException {
        String naverApiUrl = "https://openapi.naver.com/v1/nid/me";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(naverApiUrl)
                .get()
                .header("Authorization", "Bearer " + accessToken)
                .build();

        Response response = client.newCall(request)
                .execute();


        System.out.println("naver : " + response.body().string());
//        NaverUserInformation naverUserInformation = objMapper.readValue(response.body().string(), NaverUserInformation.class);
//        System.out.println("id : " + naverUserInformation.getId());

        return "main";
    }
}
