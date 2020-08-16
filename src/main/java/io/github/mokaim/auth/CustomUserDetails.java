package io.github.mokaim.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class CustomUserDetails implements UserDetails {


    private String usrEmail;
    private String usrPw;

    private List<String> roles;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

/*        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;

            roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());


    출처: https://debugdaldal.tistory.com/89 [달달한 디버깅]*/


        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usrPw;
    }

    @Override
    public String getUsername() {
        return usrEmail;
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
        return true;
    }
}
