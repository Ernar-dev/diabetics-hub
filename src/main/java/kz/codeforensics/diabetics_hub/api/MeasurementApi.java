package kz.codeforensics.diabetics_hub.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.codeforensics.diabetics_hub.domain.dto.GlucoseMonitoringDto;
import kz.codeforensics.diabetics_hub.domain.dto.MeasurementDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Measurement", description = "История измерение")

public interface MeasurementApi {

    @Operation(
            operationId = "create",
            summary = "Создать измерение"
    )
    ResponseEntity<MeasurementDto> create(@RequestBody MeasurementDto measurementDto);

    @Operation(
            operationId = "getAll",
            summary = "Просмотр история измерение"
    )
    ResponseEntity<Page<MeasurementDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam String iin);

    @Operation(
            operationId = "getGlucoseMonitoring",
            summary = "Просмотр история глюкоза"
    )
    ResponseEntity<Page<GlucoseMonitoringDto>> getGlucoseMonitoring(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size,
                                                                    @RequestParam String iin);

}
