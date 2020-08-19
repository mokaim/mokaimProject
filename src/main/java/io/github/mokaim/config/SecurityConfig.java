package io.github.mokaim.config;

import io.github.mokaim.auth.CustomAuthenticationProvider;
import io.github.mokaim.auth.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    CustomUserDetailsService customUserDetailsService;


    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

/*    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }*/

    @Bean
    public HttpFirewall defaultHttpFirewall(){
        return new DefaultHttpFirewall();
    }    // 이중 슬래쉬 요청 방지



    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);

        web.httpFirewall(defaultHttpFirewall());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .ignoringAntMatchers("/mymy")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

                .and()


                .authorizeRequests()    //요청에 대한 권한을 지정할 수 있음
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/view/**").hasRole("MEMBER")
                .antMatchers("/post**").hasRole("MEMBER")
                .antMatchers("/").hasRole("MEMBER")    //테스트
                .antMatchers("/login**","/mymy").permitAll()
               // .antMatchers("/**").permitAll()
                .and()

                .formLogin() //로그인
                .loginPage("/newlogin")
                .loginProcessingUrl("/loginpro")
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
                .authenticationProvider(customAuthenticationProvider);
          /*.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("1234"))   //스프링 2.0 부터는 패스워드를 인코딩 시켜야함
                .roles("MEMBER");*/

    }


}
