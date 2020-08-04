package com.galid.social_logins.socials.kakao;

import com.galid.social_logins.socials.kakao.vo.KakaoAccessToken;
import com.galid.social_logins.socials.kakao.vo.KakaoUserInformation;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface KakaoApi {
    @POST("/oauth/token")
    Call<KakaoAccessToken> getAccessToken(@QueryMap Map<String, String> params);

    @POST("/v2/user/me")
    Call<KakaoUserInformation> getUserInformation(@Header("Authorization") String authorization);
}
