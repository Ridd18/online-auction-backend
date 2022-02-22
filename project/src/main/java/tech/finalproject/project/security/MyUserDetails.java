package tech.finalproject.project.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.finalproject.project.buyer.BidderModel;

import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private Boolean active;
    private List<GrantedAuthority> authorities;


    public MyUserDetails(BidderModel buyer) {

        this.username = buyer.getUsername();
        this.password = buyer.getPassword();
//        this.active = buyer.isActive();
//        this.authorities = Arrays.stream(buyer.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
