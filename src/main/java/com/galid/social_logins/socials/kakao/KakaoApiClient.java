package com.galid.social_logins.socials.kakao;

import com.galid.social_logins.socials.commons.ApiBaseUrls;
import com.galid.social_logins.socials.kakao.vo.KakaoAccessToken;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

@Component
public class KakaoApiClient {
    private String clientId = "2fd5cececbba62e7626740a6d6632296";
    private String redirectUri = "http://localhost/auth/kakao/code";

    public String getUniqueId(String authorizeCode) throws IOException{
        return getApiClient(ApiBaseUrls.KAKAO_INFORMATION_BASE_URL)
                .getUserInformation("Bearer " + getAccessToken(authorizeCode))
                .execute()
                .body()
                .getId();
    }

    private String getAccessToken(String authorizeCode) throws IOException {
        Call<KakaoAccessToken> accessTokenCall = getApiClient(ApiBaseUrls.KAKAO_ACCESSTOKEN_BASE_URL)
                .getAccessToken(ofEntries(
                    entry("grant_type", "authorization_code"),
                    entry("client_id", clientId),
                    entry("redirect_uri", redirectUri),
                    entry("code", authorizeCode)
                ));
        Response<KakaoAccessToken> response = accessTokenCall.execute();
        return response.body().getAccess_token();
    }

    private KakaoApi getApiClient(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(KakaoApi.class);
    }
}
