package com.galid.social_logins;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id @GeneratedValue
    private Long memberId;

    private String socialId;
    @Enumerated(value = EnumType.STRING)
    private SocialType socialType;

    @Builder
    public MemberEntity(String socialId, SocialType socialType) {
        this.socialId = socialId;
        this.socialType = socialType;
    }
}
