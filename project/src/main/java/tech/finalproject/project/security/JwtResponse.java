package tech.finalproject.project.security;

import tech.finalproject.project.buyer.BidderModel;

public class JwtResponse {

    private BidderModel user;

    private String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public JwtResponse(BidderModel user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public BidderModel getUser() {
        return user;
    }

    public void setUser(BidderModel user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
