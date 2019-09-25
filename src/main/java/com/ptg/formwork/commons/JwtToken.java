package com.ptg.formwork.commons;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * className JwtToken
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2018/12/17 20:12
 */

public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
