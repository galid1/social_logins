package com.galid.social_logins.socials.google.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleUserInformation {
    // Google에서 Sub를 이용해 사용자를 구분하도록 권장하고 있음. (email은 추후에 변경될 가능성이 있으므로)
    private String iss;
    private String azp;
    private String aud;
    private String sub;
    private String email;
    private boolean email_verified;
    private String at_hash;
    private String name;
    private String picture;
    private String given_name;
    private String family_name;
    private String locale;
    private String iat;
    private String exp;
    private String jti;
    private String alg;
    private String kid;
    private String typ;
}
