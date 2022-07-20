package com.cloudofgoods.authservice;



import com.cloudofgoods.authservice.entity.AuthPermission;
import com.cloudofgoods.authservice.entity.AuthRole;
import com.cloudofgoods.authservice.entity.AuthUser;
import com.cloudofgoods.authservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Date;


@SpringBootApplication
@EnableSwagger2
public class AppInitializerAuth {
    public static void main(String[] args) {

        SpringApplication.run(AppInitializerAuth.class, args);
    }

    @Bean
    /* Defined in the Spring Security configuration to encode the password.
       Here create a Spring bean and drop bean to spring context.
       Then WebSecurityConfig Class passwordEncoder get this bean object from
       Spring IOC and access*/
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService service) {
        return args -> {
            service.saveAuthRole(new AuthRole(null, "ROLE_USER", new Date(), new Date()));
            service.saveAuthRole(new AuthRole(null, "ROLE_MANAGER", new Date(), new Date()));
            service.saveAuthRole(new AuthRole(null, "ROLE_ADMIN", new Date(), new Date()));
            service.saveAuthRole(new AuthRole(null, "ROLE_SUPER_ADMIN", new Date(), new Date()));

            service.saveAuthUser(new AuthUser(null, "john@gmail.com", "1234", new Date(), new Date()));
            service.saveAuthUser(new AuthUser(null, "Kamal", "12345", new Date(), new Date()));
            service.saveAuthUser(new AuthUser(null, "Nimal", "1234", new Date(), new Date()));
            service.saveAuthUser(new AuthUser(null, "AMri", "123", new Date(), new Date()));

            service.addRoleToUser("john@gmail.com", "ROLE_USER");
            service.addRoleToUser("Kamal", "ROLE_ADMIN");
            service.addRoleToUser("AMri", "ROLE_ADMIN");

           // service.saveAuthContentType(new AuthContentType(null, "AppLabel", "ModelName", new Date(), new Date()));
            //AuthContentType authContentType = service.saveAuthContentType(new AuthContentType(null, "AppLabel2", "ModelName2", new Date(), new Date()));

            service.saveAuthPermission(new AuthPermission(null, "XYZ", "1234", new Date(), new Date()));

            service.saveAuthRoleAuthPermission("1234","ROLE_USER");

//            service.saveAuthUserAuthPermission("john@gmail.com","1234");
        };
    }
}

