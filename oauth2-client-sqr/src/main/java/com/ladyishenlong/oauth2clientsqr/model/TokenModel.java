package com.ladyishenlong.oauth2clientsqr.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-07-08 13:16
 */
@Data
public class TokenModel implements Serializable {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String expires_in;
    private String scope;
}
