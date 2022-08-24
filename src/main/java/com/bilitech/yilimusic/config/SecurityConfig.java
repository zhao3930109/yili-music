package com.bilitech.yilimusic.config;


import com.bilitech.yilimusic.exception.RestAuthenticationEntryPoint;
import com.bilitech.yilimusic.filter.JwtAuthenticationFilter;
import com.bilitech.yilimusic.filter.JwtAuthorizationFilter;
import com.bilitech.yilimusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String SECRET = "YuanLiMusic";
    public static final long EXPIRATION = 864000000; // token 过期时间  18days
    public static final String TOKEN_PREFIX = "Bearer "; // token 前缀
    public static final String HEADER_STRING= "Authorization";
    public static final String SIGN_UP_URL = "/users/";


    UserService userService;

    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//                开启跨域
        http.cors()
//                关闭csrf 验证
                .and().csrf().disable()
                .authorizeHttpRequests()
//                任何人都可以请求到这个接口，不用受到401的错误
                .antMatchers(HttpMethod.POST,SIGN_UP_URL).permitAll()
                .anyRequest().authenticated()
                .and()
//                添加两个filter
                .addFilter(new JwtAuthenticationFilter(super.authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(super.authenticationManager(),userService))
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }
}


