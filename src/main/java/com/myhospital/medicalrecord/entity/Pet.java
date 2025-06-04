package com.myhospital.medicalrecord.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "pet")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "species", nullable = false)
  private String species;

  @Column(name = "breed")
  private String breed;

  @Column(name = "sex")
  private String sex;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "weight")
  private BigDecimal weight;

  @Column(name = "create_date", nullable = false)
  private LocalDateTime createDate;

  @Column(name = "update_date", nullable = false)
  private LocalDateTime updateDate;

  @Column(name = "delete_date")
  private LocalDateTime deleteDate;
}

