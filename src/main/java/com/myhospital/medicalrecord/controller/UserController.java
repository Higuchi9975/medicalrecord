package com.myhospital.medicalrecord.controller;

import com.myhospital.medicalrecord.entity.Pet;
import com.myhospital.medicalrecord.entity.User;
import com.myhospital.medicalrecord.repository.PetRepository;
import com.myhospital.medicalrecord.repository.UserRepository;
import com.myhospital.medicalrecord.service.UserService;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  UserRepository userRepository;

  @Autowired
  PetRepository petRepository;

  /**
   * ユーザー情報一覧画面を表示
   */
  @RequestMapping(value = "/user/list", method = RequestMethod.GET)
  public String displayList(Model model) {
    List<User> userlist = userService.searchAll();
    model.addAttribute("userlist", userlist);
    return "user/list";
  }

  /**
   * ユーザーに紐づくペット情報を表示
   */
  @GetMapping("/user/{id}/pets")
  public String showPets(@PathVariable Long id, Model model) {
    User user = userRepository.findById(id).orElse(null);
    List<Pet> petList = petRepository.findByUserId(id);
    model.addAttribute("user", user);
    model.addAttribute("petList", petList);
    return "pet/pet_list";
  }

  @GetMapping("/user/add")
  public String showAddUserForm(Model model) {
    model.addAttribute("user", new User());
    return "user/user_form";
  }

  @PostMapping("/user/add")
  public String addUser(@ModelAttribute User user) {
    LocalDateTime now = LocalDateTime.now();
    user.setCreateDate(now);
    user.setUpdateDate(now);
    userService.save(user); // サービス経由で保存
    return "redirect:/user/list";
  }

}
