package com.cloudofgoods.authservice.configaration;

import com.cloudofgoods.authservice.entity.AuthPermission;
import com.cloudofgoods.authservice.entity.AuthRole;
import com.cloudofgoods.authservice.entity.AuthUser;
import com.cloudofgoods.authservice.filter.CustomAuthenticationFilter;
import com.cloudofgoods.authservice.filter.CustomAuthorizationFilter;
import com.cloudofgoods.authservice.repository.AuthUserDAO;
import com.cloudofgoods.authservice.service.UserService;
import com.cloudofgoods.authservice.service.serviceimpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
 /* The WebSecurityConfig class is annotated with "@EnableWebSecurity"
    to enable Spring Security's web security support and provide the
    Spring MVC integration.*/
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {/* WebSecurityConfigurerAdapter, Tell to the spring How we want
                                                                        to manage application to the users and the security in application
                                                                        (Allows customization to both WebSecurity and HttpSecurity) */
    private final UserDetailsService userDetailsService;   /*Provided By Spring Security used to retrieve the user's
                                                             authentication and authorization information. (feed the user information to the Spring security API.)*/
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {  /*AuthenticationManagerBuilder Allows for easily
                                                                                 building in memory authentication,
                                                                                 LDAP authentication, JDBC based authentication etc...*/

        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder); // Defined PasswordEncoder bean in Main Class
    }

    private static final String[] PUBLIC_URLS = {
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v5/api-docs",
            "/webjars/**"
    };
    private final AuthUserDAO authUserDAO;
    private static List<AuthUser> all;
    private final UserService service;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure-------------------------------------");

        CustomAuthenticationFilter customAuthenticationFilter =
                new CustomAuthenticationFilter(authenticationManagerBean());// calling authenticationManagerBean() bean
        customAuthenticationFilter.setFilterProcessesUrl("/api/v5/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        // Allow to access Request from Below any URLs
        http.authorizeRequests().antMatchers("/api/v5/login/**", "/api/v5/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(PUBLIC_URLS).permitAll();
        // Allow to access Request from Below URLs with having authorized Roles
        http.authorizeRequests().antMatchers(GET, "/api/v5/users/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(GET, "/api/v5/permission/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/api/v5/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/api/v5/watch/roles/**").hasAnyAuthority("ROLE_ADMIN");
        // http.authorizeRequests().antMatchers(POST, "/api/user/update/**").hasAnyAuthority("ROLE_SUPER_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); // Calling webSecurityConfigureAdapter Class to return AuthenticationManagerDelegator which return authenticationBuilder and context
    }
}
