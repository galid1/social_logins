package com.galid.social_logins.socials.kakao.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class KakaoAccessToken {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String refresh_token_expires_in;
}
