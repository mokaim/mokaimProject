package io.github.mokaim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()    //요청에 대한 권한을 지정할 수 있음
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/view/**").hasRole("USER")
                .antMatchers("/login**").permitAll()
                .antMatchers("/**").permitAll()
                .and()

                .formLogin() //로그인
                .loginProcessingUrl("/loginProcess")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()

                .logout()  //로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/newlogout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()

                .exceptionHandling().accessDeniedPage("/deniedpage");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("1234"))   //스프링 2.0 부터는 패스워드를 인코딩 시켜야함
                .roles("USER");

    }
}
