package com.myhospital.medicalrecord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// セキュリティ設定クラス（Spring Security）
@Configuration
public class SecurityConfig {

  // セキュリティの定義
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        // 開発中のため全URLアクセス許可
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
        .formLogin(form -> form
            // ログインページのURLを指定
            .loginPage("/login")
            // ログインフォームの送信先
            .loginProcessingUrl("/login")
            // ログイン成功後のリダイレクト先
            .defaultSuccessUrl("/user/list", true)
            .permitAll()
        );

    // ★CSRF対策を無効化（開発中のみ。本番では有効にすべき）
    http.csrf(csrf -> csrf.disable());

    return http.build();
  }
}

