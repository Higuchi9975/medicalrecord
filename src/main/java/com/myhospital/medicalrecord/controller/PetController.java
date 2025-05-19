package com.myhospital.medicalrecord.controller;

import com.myhospital.medicalrecord.entity.Pet;
import com.myhospital.medicalrecord.entity.User;
import com.myhospital.medicalrecord.repository.PetRepository;
import com.myhospital.medicalrecord.repository.UserRepository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/{userId}/pets")  // ルートをユーザーIDに合わせて修正
public class PetController {

  @Autowired
  private PetRepository petRepository;

  @Autowired
  private UserRepository userRepository;

  // ペット登録フォームの表示
  @GetMapping("/add")
  public String showAddForm(@PathVariable Long userId, Model model) {
    model.addAttribute("pet", new Pet());
    model.addAttribute("user", userRepository.findById(userId).orElse(null));
    return "pet/pet_form"; // フォーム表示用テンプレートに変更
  }

  // ペット登録処理
  @PostMapping("/add")
  public String addPet(@PathVariable Long userId, @ModelAttribute Pet pet) {
    User user = userRepository.findById(userId).orElse(null);
    if (user != null) {
      pet.setUser(user);
      pet.setCreateDate(LocalDateTime.now());
      pet.setUpdateDate(LocalDateTime.now());
      petRepository.save(pet);
    }
    return "redirect:/user/" + userId + "/pets";
  }
}
