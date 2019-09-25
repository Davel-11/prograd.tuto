package com.nebulosa.auth.model;

public class UserToken {

    UserInfo userInfo;
    JwtResponse tokenData;

    public UserToken(UserInfo userInfo, JwtResponse tokenData) {
        this.userInfo = userInfo;
        this.tokenData = tokenData;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public JwtResponse getTokenData() {
        return tokenData;
    }

    public void setTokenData(JwtResponse tokenData) {
        this.tokenData = tokenData;
    }
}
