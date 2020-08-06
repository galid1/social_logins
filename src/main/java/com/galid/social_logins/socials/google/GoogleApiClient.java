package com.galid.social_logins.socials.google;

import com.galid.social_logins.socials.commons.ApiBaseUrls;
import com.galid.social_logins.socials.google.vo.GoogleUserInformation;
import com.galid.social_logins.socials.kakao.KakaoApi;
import org.springframework.stereotype.Component;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

import static java.util.Map.*;
import static java.util.Map.ofEntries;

@Component
public class GoogleApiClient {
    public String getUniqueId(String token) throws IOException {
        return getApiClient(ApiBaseUrls.GOOGLE_INFORMATION_BASE_URL)
                .getUserInformation(ofEntries(
                        entry("id_token", token)
                ))
                .execute()
                .body()
                .getSub();
    }

    private GoogleApi getApiClient(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GoogleApi.class);
    }
}
