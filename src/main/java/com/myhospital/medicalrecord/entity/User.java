package com.myhospital.medicalrecord.entity;

import java.time.LocalDateTime;
import lombok.Data;

import jakarta.persistence.*;  // ← ここを javax → jakarta に変更！


/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Column(name = "phone")
  private String phone;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "create_date")
  private LocalDateTime createDate;

  @Column(name = "delete_date")
  private LocalDateTime deleteDate;
}
