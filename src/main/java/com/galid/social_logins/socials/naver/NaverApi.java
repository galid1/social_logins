package com.galid.social_logins.socials.naver;

import com.galid.social_logins.socials.naver.vo.NaverAccessToken;
import com.galid.social_logins.socials.naver.vo.NaverUserInformation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface NaverApi {
    @GET("/oauth2.0/token")
    Call<NaverAccessToken> getAccessToken(@QueryMap Map<String, String> params);

    @GET("/v1/nid/me")
    Call<NaverUserInformation> getUserInformation(@Header("Authorization") String authorization);
}
