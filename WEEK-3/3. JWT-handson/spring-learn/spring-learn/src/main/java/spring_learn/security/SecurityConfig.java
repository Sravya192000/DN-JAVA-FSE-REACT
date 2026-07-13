package spring_learn.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {


        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> {})
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/countries")
                        .hasRole("USER")

                        .requestMatchers("/authenticate")
                        .hasAnyRole("USER", "ADMIN")

                        .anyRequest()
                        .authenticated()

                );


        return http.build();

    }


    @Bean
    public org.springframework.security.authentication.AuthenticationManager authenticationManager(
            org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();

    }
    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService users() {

        var user = org.springframework.security.core.userdetails.User
                .withUsername("user")
                .password(passwordEncoder().encode("pwd"))
                .roles("USER")
                .build();


        var admin = org.springframework.security.core.userdetails.User
                .withUsername("admin")
                .password(passwordEncoder().encode("pwd"))
                .roles("ADMIN")
                .build();


        return new org.springframework.security.provisioning.InMemoryUserDetailsManager(
                user, admin
        );
    }

}