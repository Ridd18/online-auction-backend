package tech.finalproject.project.security;

import tech.finalproject.project.buyer.BuyerLoginDetails;

public class JwtResponse {

    private BuyerLoginDetails user;

    private String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public JwtResponse(BuyerLoginDetails user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public BuyerLoginDetails getUser() {
        return user;
    }

    public void setUser(BuyerLoginDetails user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
