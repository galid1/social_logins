package com.galid.social_logins.socials.kakao.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class KakaoUserInformation {
    private String id;
    private String connected_at;
    private KakaoAccountInformation kakao_account;

    @Setter
    @Getter
    @ToString
    private static class KakaoAccountInformation {
        private boolean has_email;
        private boolean email_needs_aggreement;
    }
}
