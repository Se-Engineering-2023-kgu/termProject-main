package rest.order.reservation.Config;

import rest.order.reservation.Repository.AppUserRepo;
import rest.order.reservation.Service.UserService;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    

    // @Autowired
    // private UserService userService;

    // @Autowired
    // public SecurityConfig(UserService userService) {
    //     this.userService = userService;
    // }

    // https://magicmk.tistory.com/m/31
    // 스프링 시큐리티 추가 버전을 사용한 로그인 기본 필터체인

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        
        http
                .rememberMe()
                .key("SpringSecurityKeys_14624") // key used to generate and validate the token
                .tokenValiditySeconds(86400) // token validity period in seconds
                .rememberMeCookieName("my-remember-me-cookie") // name of the cookie
                .rememberMeParameter("remember-me") // parameter name in the login form
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/customer/**").authenticated() // 이 경로로 진입하면 인증을 요구함
                .requestMatchers("/admin/**").authenticated() // 이 경로로 진입하면 ADMIN 역할을 가진 인증을 요구함
                .anyRequest().permitAll() // 그 외에는 허용
                .and()
                .formLogin() // http form 방식의 로그인 진행
                .loginPage("/login/login") // controller에 정의한 로그인 페이지 (강제로 이상한데 가도 이 페이지로 감)
                .loginProcessingUrl("/login/login") // form submit해서 제출하는 로그인 페이지
                .usernameParameter("loginId") // 타임리프 페이지에서 받을 http form 파라미터 (기본값 : username)
                .passwordParameter("loginPwd") // pw 파라미터를 제출받음 
                .defaultSuccessUrl("/customer/", true) // 로그인 하면 id 페이지로 이동 >> 파라미터 만들어야 함
                .failureUrl("/login/login?error=true") // 로그인 실패하면 error=true 파라미터 페이지로 나오게 하기 (다른 경로 가능)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/customer/logout") // 로그아웃 경로 들어가면 세션 날리고 쿠키도 나림
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .rememberMe().key("SpringSecurityKeys_14624") // 암호화 키 (이걸로 암호화 함)
                .and()
                .httpBasic()
                .and()
                .csrf().disable() // csrf 끄기
                .headers().frameOptions().disable(); // x -forward 끄기
        ;

        http.headers().frameOptions().sameOrigin();
        // https://ksyy.tistory.com/306 관련 글
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 정적 리소스들이 보안필터를 거치지 않게끔
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/img/**", "/font/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider AuthenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


}