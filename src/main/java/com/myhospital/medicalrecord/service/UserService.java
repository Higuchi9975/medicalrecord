package com.myhospital.medicalrecord.service;

import com.myhospital.medicalrecord.entity.User;
import com.myhospital.medicalrecord.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ユーザー情報 Service
 */
@Service
public class UserService {

  /**
   * ユーザー情報 Repository
   */
  @Autowired
  UserRepository userRepository;

  public List<User> searchAll() {
    // ユーザーTBLの内容を全検索
    return userRepository.findAll();
  }
/**IDでユーザーを取得する**/
  public User findById(Long id) {
    return userRepository.findById(id).orElseThrow();
  }

  public void save(User user) {
    userRepository.save(user);
  }


}
