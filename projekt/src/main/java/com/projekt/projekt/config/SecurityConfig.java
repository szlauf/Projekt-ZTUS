package com.projekt.projekt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${google.recaptcha.key.site}")
    private String recaptchaSiteKey;

    @Value("${google.recaptcha.key.secret}")
    private String recaptchaSecretKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/login").permitAll()
                        .requestMatchers("/registration").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/vid/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .anyRequest().authenticated()
            ).formLogin(form -> 
                    form.loginPage("/login")
                            .permitAll()
                            .loginProcessingUrl("/process-login") // The URL to submit the login form
                            .failureUrl("/login?error=true") // Redirect to this URL after login failure
                            .successHandler(authenticationSuccessHandler())
            )
            .httpBasic(Customizer.withDefaults())
            .addFilterBefore(new CaptchaFilter(recaptchaSecretKey), UsernamePasswordAuthenticationFilter.class)
            .build();
    }
    // Konfiguracja szyfrowania haseł
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Konfiguracja obsługi sukcesu logowania
    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
    // Konfiguracja dostawcy uwierzytelniania
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
