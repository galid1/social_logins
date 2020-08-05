package com.galid.social_logins.socials.naver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galid.social_logins.socials.commons.ApiBaseUrls;
import com.galid.social_logins.socials.naver.vo.NaverAccessToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

import static java.util.Map.*;

@Component
@RequiredArgsConstructor
public class NaverApiClient {
    private final ObjectMapper objMapper;
    private String clientId = "6jdWKyokOP5L5bpCtYOx";
    private String clientSecret = "Mh8pNDKBuf";

    public String getUniqueId(String authorizeCode) throws IOException {
        return getApiClient(ApiBaseUrls.NAVER_INFORMATION_BASE_URL)
                .getUserInformation("Bearer " + getAccessToken(authorizeCode))
                .execute()
                .body()
                .getId();
    }

    private String getAccessToken(String authorizeCode) throws IOException {
        Call<NaverAccessToken> accessTokenCall = getApiClient(ApiBaseUrls.NAVER_ACCESSTOKEN_BASE_URL)
                .getAccessToken(ofEntries(
                        entry("client_id", clientId),
                        entry("client_secret", clientSecret),
                        entry("grant_type", "authorization_code"),
                        entry("code", authorizeCode)
                ));

        Response<NaverAccessToken> response = accessTokenCall.execute();
        return response.body().getAccess_token();
    }

    private NaverApi getApiClient(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NaverApi.class);
    }
}
