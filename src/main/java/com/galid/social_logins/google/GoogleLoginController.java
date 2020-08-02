package com.galid.social_logins.google;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class GoogleLoginController {

    @PostMapping("/auth/google")
    @ResponseBody
    public String authGoogle(@RequestParam("idtoken") String token) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://oauth2.googleapis.com/tokeninfo?id_token=" + token)
                .get()
                .build();

        try {
            Response response = client.newCall(request)
                    .execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }

}
