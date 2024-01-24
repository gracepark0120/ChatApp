package com.cor.chatapp.Security;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtToken {
    private String grantType; //jwt 인증 타입 - bearer, access token을 http 요청의 authentication 헤더에 포함하여 전송
    private String accessToken;
    private String refreshToken;
}
