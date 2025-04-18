package kz.codeforensics.diabetics_hub.controller;

import kz.codeforensics.diabetics_hub.api.MeasurementApi;
import kz.codeforensics.diabetics_hub.domain.dto.GlucoseMonitoringDto;
import kz.codeforensics.diabetics_hub.domain.dto.MeasurementDto;
import kz.codeforensics.diabetics_hub.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/diabetics/measurement")
public class MeasurementController implements MeasurementApi {

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/create")
    public ResponseEntity<MeasurementDto> create(@RequestBody MeasurementDto measurementDto){
        return ResponseEntity.ok().body(measurementService.create(measurementDto));
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<MeasurementDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam String iin) {
        Pageable pageable = PageRequest.of(page, size);
        var response = measurementService.getAll(pageable, iin);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/get-glucose-monitoring")
    public ResponseEntity<Page<GlucoseMonitoringDto>> getGlucoseMonitoring(@RequestParam(defaultValue = "0") int page,
                                                                           @RequestParam(defaultValue = "10") int size,
                                                                           @RequestParam String iin) {
        Pageable pageable = PageRequest.of(page, size);
        var response = measurementService.getGlucoseMonitoring(pageable, iin);
        return ResponseEntity.ok().body(response);
    }

}
