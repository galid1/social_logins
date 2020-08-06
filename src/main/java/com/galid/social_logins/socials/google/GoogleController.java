package com.galid.social_logins.socials.google;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class GoogleController {
    private final GoogleApiClient googleApiClient;

    @PostMapping("/auth/google")
    @ResponseBody
    public String authGoogle(@RequestParam("idtoken") String token) throws IOException {
        System.out.println("google : " + googleApiClient.getUniqueId(token));
        return "ok";
    }

}
