package kz.codeforensics.diabetics_hub.controller;

import kz.codeforensics.diabetics_hub.api.PatientApi;
import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import kz.codeforensics.diabetics_hub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/diabetics/patient")
public class PatientController implements PatientApi {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<PatientDto> create(@RequestBody PatientDto patientDto) {
        return ResponseEntity.ok().body(patientService.create(patientDto));
    }

    @GetMapping("/get")
    public ResponseEntity<PatientDto> get(){
        return ResponseEntity.ok().body(patientService.get());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        return ResponseEntity.ok().body(patientService.updatePatient(id, patientDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }

}
