package tech.finalproject.project.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.finalproject.project.buyer.BuyerLoginDetails;
import tech.finalproject.project.buyer.BuyerRepo;
import tech.finalproject.project.buyer.BuyerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private BuyerRepo buyerRepo;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User("foo","foo", new ArrayList<>());
//        Optional<BuyerLoginDetails> buyer =  buyerRepo.findByUsername(username);
//
//        buyer.orElseThrow(()-> new UsernameNotFoundException("Not Found:"+ username));
//
//        return buyer.map(MyUserDetails::new).get();
    }

}
