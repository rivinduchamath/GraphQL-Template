package com.cloudofgoods.authservice.configaration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
 /* The WebSecurityConfig class is annotated with "@EnableWebSecurity"
    to enable Spring Security's web security support and provide the
    Spring MVC integration.*/
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {/* WebSecurityConfigurerAdapter, Tell to the spring How we want
                                                                        to manage application to the users and the security in application
                                                                        (Allows customization to both WebSecurity and HttpSecurity) */

}
