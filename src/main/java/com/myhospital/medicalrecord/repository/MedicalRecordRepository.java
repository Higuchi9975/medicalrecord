package com.myhospital.medicalrecord.repository;

import com.myhospital.medicalrecord.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
