package io.github.mokaim.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    CustomUserDetailsService customUserDetailsService;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getPrincipal().toString();
        String userpass = authentication.getCredentials().toString();

        log.info("username = " + username);
        log.info("userpass = " + userpass);


        CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(username);

        if(!matchPass(userpass, customUserDetails.getPassword())){
            throw new BadCredentialsException(username);
        }

        if(!customUserDetails.isEnabled()){
            throw new BadCredentialsException(username);
        }


        return new UsernamePasswordAuthenticationToken(username, userpass, customUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private boolean matchPass(String loginPass, String dbPass){
        boolean check = passwordEncoder.matches(loginPass, dbPass);

        log.info("password check : " + check);

        return check;
    }


}
