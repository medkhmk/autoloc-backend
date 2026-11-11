package fr.ece.autoloc_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // 1. Utilisateur standard (USER)
        UserDetails student = User.withUsername("student")
                .password(encoder.encode("student123"))
                .roles("USER").build();

        // 2. Les 4 membres du groupe (ADMIN)
        UserDetails khalifa = User.withUsername("khalifa")
                .password(encoder.encode("khalifa123"))
                .roles("ADMIN").build();

        UserDetails kenza = User.withUsername("kenza")
                .password(encoder.encode("kenza123"))
                .roles("ADMIN").build();

        UserDetails mithulan = User.withUsername("mithulan")
                .password(encoder.encode("mithulan123"))
                .roles("ADMIN").build();

        UserDetails aida = User.withUsername("aida")
                .password(encoder.encode("aida123"))
                .roles("ADMIN").build();



        return new InMemoryUserDetailsManager(student, khalifa, kenza, mithulan, aida);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/actuator/**").permitAll()
                .requestMatchers("/api/public/**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
        ).httpBasic(org.springframework.security.config.Customizer.withDefaults());
        return http.build();
    }
}