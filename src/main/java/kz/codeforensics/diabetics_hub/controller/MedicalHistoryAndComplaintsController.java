package kz.codeforensics.diabetics_hub.controller;

import kz.codeforensics.diabetics_hub.api.MedicalHistoryAndComplaintsApi;
import kz.codeforensics.diabetics_hub.domain.dto.MedicalHistoryAndComplaintsDto;
import kz.codeforensics.diabetics_hub.service.MedicalHistoryAndComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/diabetics/medical")
public class MedicalHistoryAndComplaintsController implements MedicalHistoryAndComplaintsApi {

    private final MedicalHistoryAndComplaintsService medicalHistoryAndComplaintsService;

    @Autowired
    public MedicalHistoryAndComplaintsController(MedicalHistoryAndComplaintsService medicalHistoryAndComplaintsService) {
        this.medicalHistoryAndComplaintsService = medicalHistoryAndComplaintsService;
    }

    @PostMapping("/create")
    public ResponseEntity<MedicalHistoryAndComplaintsDto> create(@RequestBody MedicalHistoryAndComplaintsDto dto) {
        return ResponseEntity.ok().body(medicalHistoryAndComplaintsService.create(dto));
    }

    @GetMapping("/get")
    public ResponseEntity<MedicalHistoryAndComplaintsDto> getMedicalHistoryAndComplaints() {
        return ResponseEntity.ok().body(medicalHistoryAndComplaintsService.getMedicalHistoryAndComplaints());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MedicalHistoryAndComplaintsDto> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(medicalHistoryAndComplaintsService.getId(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<MedicalHistoryAndComplaintsDto>> getAllMedicalHistoryAndComplaints(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        var response = medicalHistoryAndComplaintsService.getAll(pageable);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MedicalHistoryAndComplaintsDto> updateMedicalHistoryAndComplaintsDto(@PathVariable Long id, @RequestBody MedicalHistoryAndComplaintsDto dto) {
        return ResponseEntity.ok().body(medicalHistoryAndComplaintsService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedicalHistoryAndComplaints(@PathVariable Long id) {
        medicalHistoryAndComplaintsService.delete(id);
        return ResponseEntity.ok().build();
    }

}
