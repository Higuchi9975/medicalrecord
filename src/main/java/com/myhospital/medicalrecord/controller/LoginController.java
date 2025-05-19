package com.myhospital.medicalrecord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  // 🔽 http://localhost:8080 にアクセスされたら /login にリダイレクト
  @GetMapping("/")
  public String redirectToLogin() {
    return "redirect:/login";
  }

  @GetMapping("/login")
  public String showLoginForm() {
    return "user/login"; // → templates/user/login.html を返す
  }
}
