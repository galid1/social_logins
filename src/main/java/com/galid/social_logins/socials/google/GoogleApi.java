package com.galid.social_logins.socials.google;

import com.galid.social_logins.socials.google.vo.GoogleUserInformation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface GoogleApi {
    @GET("/tokeninfo")
    Call<GoogleUserInformation> getUserInformation(@QueryMap Map<String, String> params);
}
