package kz.codeforensics.diabetics_hub.controller;

import kz.codeforensics.diabetics_hub.api.MedicalHistoryAndComplaintsApi;
import kz.codeforensics.diabetics_hub.domain.dto.MedicalHistoryAndComplaintsDto;
import kz.codeforensics.diabetics_hub.service.MedicalHistoryAndComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<MedicalHistoryAndComplaintsDto> create(@RequestBody MedicalHistoryAndComplaintsDto dto){

        return ResponseEntity.ok().body(medicalHistoryAndComplaintsService.create(dto));

    }

    @GetMapping("/get")
    public String get(){
        return "Patient is date analyses";
    }

    @GetMapping("/get-all")
    public String getAll(){
        return "List of all patients";
    }

}
