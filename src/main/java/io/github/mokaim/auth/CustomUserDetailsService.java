package io.github.mokaim.auth;

import io.github.mokaim.mapper.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomUserDetails customUserDetails = userRepository.identifyUser(email);

        if(customUserDetails == null){
            log.info("없는 아이디");
            throw new BadCredentialsException(email);
        }else{
            log.info("성공");
            return customUserDetails;
        }

    }
}
