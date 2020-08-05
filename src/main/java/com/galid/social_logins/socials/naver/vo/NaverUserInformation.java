package com.galid.social_logins.socials.naver.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NaverUserInformation {
    private String resultcode;
    private String message;
    private UserInformation response;

    @Getter
    @Setter
    public static class UserInformation {
        private String id;
        private String email;
    }
}
