package kz.codeforensics.diabetics_hub.controller;

import kz.codeforensics.diabetics_hub.domain.dto.PatientHistoryDto;
import kz.codeforensics.diabetics_hub.mapper.PatientHistoryMapper;
import kz.codeforensics.diabetics_hub.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/diabetics/patient-history")
public class PatientHistoryController {

    private final PatientHistoryService patientHistoryService;
    private final PatientHistoryMapper patientHistoryMapper;

    @Autowired
    public PatientHistoryController(PatientHistoryService patientHistoryService, PatientHistoryMapper patientHistoryMapper) {
        this.patientHistoryService = patientHistoryService;
        this.patientHistoryMapper = patientHistoryMapper;
    }


    @PostMapping("/create")
    public ResponseEntity<PatientHistoryDto> create(@RequestBody PatientHistoryDto patientHistoryDto){
        return ResponseEntity.ok().body(patientHistoryService.create(patientHistoryDto));
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<PatientHistoryDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size,
                                                         @RequestParam(defaultValue = "registrationDate") String sortBy,
                                                         @RequestParam(defaultValue = "DESC") String sortDirection){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
        var response = patientHistoryService.getAll(pageable).map(patientHistoryMapper::mapToDto);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get/{registrationNumber}")
    public ResponseEntity<PatientHistoryDto> getRegistrationNumber(@PathVariable Long registrationNumber){
        if (registrationNumber == null){
            throw new RuntimeException("registrationNumber is null");
        }
        return ResponseEntity.ok().body(patientHistoryService.getRegistrationNumber(registrationNumber));
    }

    @PostMapping("/update")
    public ResponseEntity<PatientHistoryDto> update(@RequestBody PatientHistoryDto patientHistoryDto){
        return ResponseEntity.ok().body(patientHistoryService.update(patientHistoryDto));
    }

    @DeleteMapping("delete/{registrationNumber}")
    public ResponseEntity<Void> deleteRegistrationNumber(@PathVariable Long registrationNumber){
        return ResponseEntity.ok().body(patientHistoryService.deleteRegistrationNumber(registrationNumber));
    }

}
