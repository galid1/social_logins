package com.galid.social_logins;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long signUp(MemberJoinRequest joinRequest) {
        validateDuplicateId(joinRequest.getSocialId());

        MemberEntity entity = memberRepository.save(joinRequest.toEntity());
        return entity.getMemberId();
    }

    private void validateDuplicateId(String socialId) {
        if(memberRepository.findFirstBySocialId(socialId)
            .isPresent())
            throw new IllegalStateException("이미 가입된 상태입니다.");
    }
}
