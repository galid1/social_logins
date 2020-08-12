package com.galid.social_logins;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberJoinRequest {
    private SocialType socialType;
    private String socialId;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .socialId(this.socialId)
                .socialType(this.socialType)
                .build();
    }
}
