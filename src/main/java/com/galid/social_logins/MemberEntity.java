package com.galid.social_logins;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id @GeneratedValue
    private Long memberId;

    private String email;
    private String authId;

    @Builder
    public MemberEntity(String email, String authId) {
        this.email = email;
        this.authId = authId;
    }
}
