package com.myhospital.medicalrecord.controller;

import com.myhospital.medicalrecord.entity.MedicalRecord;
import com.myhospital.medicalrecord.entity.Pet;
import com.myhospital.medicalrecord.repository.MedicalRecordRepository;
import com.myhospital.medicalrecord.repository.PetRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets/{petId}/medical")
public class MedicalRecordController {

  @Autowired
  private PetRepository petRepository;

  @Autowired
  private MedicalRecordRepository medicalRecordRepository;

  @GetMapping("/add")
  public String showAddForm(@PathVariable Long petId, Model model) {
    Pet pet = petRepository.findById(petId).orElse(null);
    model.addAttribute("medicalRecord", new MedicalRecord());
    model.addAttribute("pet", pet);
    List<MedicalRecord> recordList = medicalRecordRepository.findByPetIdOrderByVisitDateDesc(petId);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    List<Map<String, String>> recordViewList = recordList.stream()
        .map(record -> {
          Map<String, String> map = new HashMap<>();
          map.put("visitDate", record.getVisitDate().format(formatter));
          map.put("symptoms", record.getSymptoms());
          map.put("treatment", record.getTreatment());
          return map;
        })
        .collect(Collectors.toList());

    model.addAttribute("medicalList", recordViewList);
    return "pet/medical_form";
  }

  @PostMapping("/add")
  public String save(@PathVariable Long petId, @ModelAttribute MedicalRecord medicalRecord) {
    Pet pet = petRepository.findById(petId).orElse(null);
    if (pet != null) {
      medicalRecord.setPet(pet);
      medicalRecord.setVisitDate(LocalDate.now()); // or from form
      medicalRecordRepository.save(medicalRecord);
    }
    return "redirect:/pets/" + petId + "/medical/add";
  }
}
