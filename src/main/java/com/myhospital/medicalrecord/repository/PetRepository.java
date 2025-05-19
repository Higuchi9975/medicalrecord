package com.myhospital.medicalrecord.repository;

import com.myhospital.medicalrecord.entity.Pet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
  // 必要ならカスタムメソッドを書く（例：findByUserなど）

  List<Pet> findByUserId(Long userId);

}

