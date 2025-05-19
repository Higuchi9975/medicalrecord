package com.myhospital.medicalrecord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()  // 開発中なので全部アクセス許可
        )
        .formLogin(form -> form
            .loginPage("/login")                 // 自作ログイン画面
            .loginProcessingUrl("/login")        // フォームの action と一致
            .defaultSuccessUrl("/user/list", true) // ログイン成功後の画面
            .permitAll()
        )
        .logout(logout -> logout
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        );
    http.csrf(csrf -> csrf.disable());
    // 開発中はオフにしておく

    return http.build();
  }
}
