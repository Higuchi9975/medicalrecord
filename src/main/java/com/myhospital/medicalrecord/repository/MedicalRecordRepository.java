package com.myhospital.medicalrecord.repository;

import com.myhospital.medicalrecord.entity.MedicalRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
  List<MedicalRecord> findByPetIdOrderByVisitDateDesc(Long petId);

}
