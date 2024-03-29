package tech.finalproject.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.persistence.Column;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFIlter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


       final String header = request.getHeader("Authorization");

       String jwtToken = null;
       String username = null;

//       if (header != null && header.startsWith("Bearer "))
//       {
//           jwtToken = header.substring(7);
//
//           try
//           {
//               username= jwtUtil.getUserNameFromToken(jwtToken);
//           }
//           catch (IllegalArgumentException e)
//           {
//               System.out.println("Unable to get Jwt Token");
//           }
//       }
//       else
//       {
//           System.out.println("Jwt token does not start with bearer");
//       }

       if (username!= null && SecurityContextHolder.getContext().getAuthentication() == null)
       {
           UserDetails userDetails = this.jwtService.loadUserByUsername(username);

           if (jwtUtil.validateToken(jwtToken, userDetails))
           {
              UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                      new UsernamePasswordAuthenticationToken(userDetails,
                              null,
                              userDetails.getAuthorities());

              usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

              SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
           }
       }
       filterChain.doFilter(request,response);
    }
}
