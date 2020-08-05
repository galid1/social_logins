package com.galid.social_logins.socials.naver.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverAccessToken {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private String expires_in;
}

